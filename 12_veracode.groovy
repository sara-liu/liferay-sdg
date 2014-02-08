import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.NoSuchOrganizationException;
import com.liferay.portal.NoSuchUserGroupException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
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

// Create test account for Veracode

User veracodeUser = UserLocalServiceUtil.addDefaultAdminUser(
	companyId, "veracode", "veracode@liferay.com", Locale.US, "Veracode", null,
	"Test");

UserLocalServiceUtil.updatePassword(
	veracodeUser.getUserId(), "VC#test32", "VC#test32", false);

long[] addUserIds = [veracodeUser.getUserId()];

try {
	Organization organization = OrganizationLocalServiceUtil.getOrganization(
		companyId, "Organizations Name");

	UserServiceUtil.addOrganizationUsers(
		organization.getOrganizationId(), addUserIds);
}
catch (NoSuchOrganizationException nsoe) {
}

try {
	UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(
		companyId, "User Group Name");

	UserServiceUtil.addUserGroupUsers(userGroup.getUserGroupId(), addUserIds);
}
catch (NoSuchUserGroupException nsuge) {
}