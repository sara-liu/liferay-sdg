import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

userId = PortalUtil.getUserId(actionRequest);

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	actionRequest);

serviceContext.setScopeGroupId(groupId);

// Control Panel

Layout welcomeLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId,
	false, "/home");

Layout controlPanelLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Control Panel", "", "", "url", false,
	"/control-panel", serviceContext);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, controlPanelLayout.getLayoutId(),
	"url=/group/control_panel?refererPlid=" +
	String.valueOf(welcomeLayout.getPlid()));