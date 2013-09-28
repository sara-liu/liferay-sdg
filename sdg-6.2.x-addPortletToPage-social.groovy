import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.PortletPreferences;

/**
 * @author Sara Liu
 */
userId = PortalUtil.getUserId(actionRequest);

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	Group.class.getName(), actionRequest);

// Activities page

Layout layoutActivities = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/activities");

UnicodeProperties typeSettingsPropertiesActivities =
	layoutActivities.getTypeSettingsProperties();

typeSettingsPropertiesActivities.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesActivities.setProperty("column-2", "116");
typeSettingsPropertiesActivities.setProperty(
	"column-1", "71_INSTANCE_uixmz6y3dFa7,");

layoutActivities.setTypeSettingsProperties(typeSettingsPropertiesActivities);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutActivities.getLayoutId(),
	layoutActivities.getTypeSettings());

UnicodeProperties propertiesActivities = new UnicodeProperties();

propertiesActivities.setProperty("displayStyle", "from-level-0");
propertiesActivities.setProperty("headerType", "root-layout");
propertiesActivities.setProperty("bulletStyle", "dots");
propertiesActivities.setProperty("rootLayoutType", "absolute");
propertiesActivities.setProperty("includedLayouts", "auto");
propertiesActivities.setProperty("nestedChildren", "1");
propertiesActivities.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceActivities", "71_INSTANCE_uixmz6y3dFa7");

portletResourceActivities = (String)actionRequest.getAttribute(
	"portletResourceActivities");

PortletPreferences portletPreferencesActivities =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceActivities);

for (Map.Entry<String, String> entry : propertiesActivities.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesActivities.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutActivities.getPlid(), "71_INSTANCE_uixmz6y3dFa7",
	portletPreferencesActivities);

// Statistics page

Layout layoutStatistics = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/statistics");

UnicodeProperties typeSettingsPropertiesStatistics =
	layoutStatistics.getTypeSettingsProperties();

typeSettingsPropertiesStatistics.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesStatistics.setProperty("column-2", "180,181,");
typeSettingsPropertiesStatistics.setProperty(
	"column-1", "71_INSTANCE_7aLiwAW9pz6q,");

layoutStatistics.setTypeSettingsProperties(typeSettingsPropertiesStatistics);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutStatistics.getLayoutId(),
	layoutStatistics.getTypeSettings());

UnicodeProperties propertiesStatistics = new UnicodeProperties();

propertiesStatistics.setProperty("displayStyle", "from-level-0");
propertiesStatistics.setProperty("headerType", "root-layout");
propertiesStatistics.setProperty("bulletStyle", "dots");
propertiesStatistics.setProperty("rootLayoutType", "absolute");
propertiesStatistics.setProperty("includedLayouts", "auto");
propertiesStatistics.setProperty("nestedChildren", "1");
propertiesStatistics.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceStatistics", "71_INSTANCE_7aLiwAW9pz6q");

portletResourceStatistics = (String)actionRequest.getAttribute(
	"portletResourceStatistics");

PortletPreferences portletPreferencesStatistics =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceStatistics);

for (Map.Entry<String, String> entry : propertiesStatistics.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesStatistics.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutStatistics.getPlid(), "71_INSTANCE_7aLiwAW9pz6q",
	portletPreferencesStatistics);

// Requests page

Layout layoutRequests = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/requests");

UnicodeProperties typeSettingsPropertiesRequests =
	layoutRequests.getTypeSettingsProperties();

typeSettingsPropertiesRequests.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesRequests.setProperty("column-2", "121");
typeSettingsPropertiesRequests.setProperty(
	"column-1", "71_INSTANCE_Nk6uVxsVxeRo,");

layoutRequests.setTypeSettingsProperties(typeSettingsPropertiesRequests);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutRequests.getLayoutId(),
	layoutRequests.getTypeSettings());

UnicodeProperties propertiesRequests = new UnicodeProperties();

propertiesRequests.setProperty("displayStyle", "from-level-0");
propertiesRequests.setProperty("headerType", "root-layout");
propertiesRequests.setProperty("bulletStyle", "dots");
propertiesRequests.setProperty("rootLayoutType", "absolute");
propertiesRequests.setProperty("includedLayouts", "auto");
propertiesRequests.setProperty("nestedChildren", "1");
propertiesRequests.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceRequests", "71_INSTANCE_Nk6uVxsVxeRo");

portletResourceRequests = (String)actionRequest.getAttribute(
	"portletResourceRequests");

PortletPreferences portletPreferencesRequests =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceRequests);

for (Map.Entry<String, String> entry : propertiesRequests.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesRequests.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutRequests.getPlid(), "71_INSTANCE_Nk6uVxsVxeRo",
	portletPreferencesRequests);
