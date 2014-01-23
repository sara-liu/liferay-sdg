import com.liferay.portal.kernel.util.UnicodeProperties;
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

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

userId = PortalUtil.getUserId(actionRequest);

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	actionRequest);

serviceContext.setScopeGroupId(groupId);

// Social

Layout socialLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Social", "", "", "link_to_layout", false,
	"/social", serviceContext);

// Activities

Layout activitiesLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, socialLayout.getLayoutId(), "Activities", "", "",
	"portlet", false, "/activities", serviceContext);

LayoutTypePortlet activitiesLayoutTypePortlet =
	(LayoutTypePortlet)activitiesLayout.getLayoutType();

activitiesLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SocialSM0001", "column-1", -1, false);
activitiesLayoutTypePortlet.addPortletId(userId, "116", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, activitiesLayout.getLayoutId(),
	activitiesLayout.getTypeSettings());

// Group Statistics

Layout groupStatisticsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, socialLayout.getLayoutId(), "Group Statistics", "",
	"", "portlet", false, "/group-statistics", serviceContext);

LayoutTypePortlet groupStatisticsLayoutTypePortlet =
	(LayoutTypePortlet)groupStatisticsLayout.getLayoutType();

groupStatisticsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SocialSM0002", "column-1", -1, false);
groupStatisticsLayoutTypePortlet.addPortletId(
	userId, "181", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, groupStatisticsLayout.getLayoutId(),
	groupStatisticsLayout.getTypeSettings());

// Requests

Layout requestsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, socialLayout.getLayoutId(), "Requests", "", "",
	"portlet", false, "/requests", serviceContext);

LayoutTypePortlet requestsLayoutTypePortlet =
	(LayoutTypePortlet)requestsLayout.getLayoutType();

requestsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SocialSM0003", "column-1", -1, false);
requestsLayoutTypePortlet.addPortletId(userId, "121", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, requestsLayout.getLayoutId(),
	requestsLayout.getTypeSettings());

// User Statistics

Layout userStatisticsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, socialLayout.getLayoutId(), "User Statistics", "",
	"", "portlet", false, "/user-statistics", serviceContext);

LayoutTypePortlet userStatisticsLayoutTypePortlet =
	(LayoutTypePortlet)userStatisticsLayout.getLayoutType();

userStatisticsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SocialSM0004", "column-1", -1, false);
userStatisticsLayoutTypePortlet.addPortletId(userId, "67", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, userStatisticsLayout.getLayoutId(),
	userStatisticsLayout.getTypeSettings());

// Link parent page with first child page

UnicodeProperties socialTypeSettingsProperties =
	socialLayout.getTypeSettingsProperties();

socialTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(activitiesLayout.getLayoutId()));

socialLayout.setTypeSettingsProperties(socialTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, socialLayout.getLayoutId(), socialLayout.getTypeSettings());
