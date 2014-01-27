import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

userId = PortalUtil.getUserId(actionRequest);

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	actionRequest);

serviceContext.setScopeGroupId(groupId);

// Welcome

Layout welcomeLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/home");

LayoutTypePortlet welcomeLayoutTypePortlet =
	(LayoutTypePortlet)welcomeLayout.getLayoutType();

welcomeLayoutTypePortlet.removePortletId(userId, "47");
welcomeLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_WelcomSM0001", "column-1", -1, false);
welcomeLayoutTypePortlet.movePortletId(userId, "58", "column-2", -1);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, welcomeLayout.getLayoutId(),
	welcomeLayout.getTypeSettings());
