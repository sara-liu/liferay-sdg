import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.NoSuchOrganizationException;
import com.liferay.portal.NoSuchUserGroupException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;

import java.util.Locale;

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	actionRequest);

serviceContext.setScopeGroupId(groupId);

// Create test account for Veracode

User veracodeUser = UserLocalServiceUtil.addUser(
	0, companyId, false, "VC#test32", "VC#test32", false, "veracode",
	"veracode@liferay.com", 0, null, Locale.US, "Veracode", null, "Test", 0, 0,
	true, 0, 1, 1970, null, null, null, null, null, true, serviceContext);

long[] addUserIds = [veracodeUser.getUserId()];

UserLocalServiceUtil.addGroupUsers(groupId, addUserIds);

Role role = RoleLocalServiceUtil.getRole(companyId, "Site Administrator");

long[] addRoleIds = [role.getRoleId()];

UserGroupRoleLocalServiceUtil.addUserGroupRoles(
	veracodeUser.getUserId(), groupId, addRoleIds);

try {
	Organization organization = OrganizationLocalServiceUtil.getOrganization(
		companyId, "Organizations Name");

	UserLocalServiceUtil.addOrganizationUsers(
		organization.getOrganizationId(), addUserIds);
}
catch (NoSuchOrganizationException nsoe) {
}

try {
	UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(
		companyId, "User Group Name");

	UserLocalServiceUtil.addUserGroupUsers(
		userGroup.getUserGroupId(), addUserIds);
}
catch (NoSuchUserGroupException nsuge) {
}