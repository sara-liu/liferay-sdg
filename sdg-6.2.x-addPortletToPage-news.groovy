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

// Alerts page

Layout layoutAlerts = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/alerts");

UnicodeProperties typeSettingsPropertiesAlerts =
	layoutAlerts.getTypeSettingsProperties();

typeSettingsPropertiesAlerts.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesAlerts.setProperty("column-2", "83");
typeSettingsPropertiesAlerts.setProperty("column-1", "71_INSTANCE_ceopyQMpL4Tj,");

layoutAlerts.setTypeSettingsProperties(typeSettingsPropertiesAlerts);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutAlerts.getLayoutId(),
	layoutAlerts.getTypeSettings());

UnicodeProperties propertiesAlerts = new UnicodeProperties();

propertiesAlerts.setProperty("displayStyle", "from-level-0");
propertiesAlerts.setProperty("headerType", "root-layout");
propertiesAlerts.setProperty("bulletStyle", "dots");
propertiesAlerts.setProperty("rootLayoutType", "absolute");
propertiesAlerts.setProperty("includedLayouts", "auto");
propertiesAlerts.setProperty("nestedChildren", "1");
propertiesAlerts.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceAlerts", "71_INSTANCE_ceopyQMpL4Tj");

portletResourceAlerts = (String)actionRequest.getAttribute(
	"portletResourceAlerts");

PortletPreferences portletPreferencesAlerts =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceAlerts);

for (Map.Entry<String, String> entry : propertiesAlerts.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesAlerts.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutAlerts.getPlid(), "71_INSTANCE_ceopyQMpL4Tj",
	portletPreferencesAlerts);

// Announcements page

Layout layoutAnnouncement = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/announcements");

UnicodeProperties typeSettingsPropertiesAnnouncement =
	layoutAnnouncement.getTypeSettingsProperties();

typeSettingsPropertiesAnnouncement.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesAnnouncement.setProperty("column-2", "84");
typeSettingsPropertiesAnnouncement.setProperty(
	"column-1", "71_INSTANCE_9svey4gIknoo,");

layoutAnnouncement.setTypeSettingsProperties(
	typeSettingsPropertiesAnnouncement);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutAnnouncement.getLayoutId(),
	layoutAnnouncement.getTypeSettings());

UnicodeProperties propertiesAnnouncement = new UnicodeProperties();

propertiesAnnouncement.setProperty("displayStyle", "from-level-0");
propertiesAnnouncement.setProperty("headerType", "root-layout");
propertiesAnnouncement.setProperty("bulletStyle", "dots");
propertiesAnnouncement.setProperty("rootLayoutType", "absolute");
propertiesAnnouncement.setProperty("includedLayouts", "auto");
propertiesAnnouncement.setProperty("nestedChildren", "1");
propertiesAnnouncement.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceAnnouncement", "71_INSTANCE_9svey4gIknoo");

portletResourceAnnouncement = (String)actionRequest.getAttribute(
	"portletResourceAnnouncement");

PortletPreferences portletPreferencesAnnouncement =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceAnnouncement);

for (Map.Entry<String, String> entry : propertiesAnnouncement.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesAnnouncement.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutAnnouncement.getPlid(), "71_INSTANCE_9svey4gIknoo",
	portletPreferencesAnnouncement);

// Rss page

Layout layoutRSS = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/rss");

UnicodeProperties typeSettingsPropertiesRSSPage =
	layoutRSS.getTypeSettingsProperties();

typeSettingsPropertiesRSSPage.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesRSSPage.setProperty(
	"column-2", "39_INSTANCE_vn59KhKI7Y2w");
typeSettingsPropertiesRSSPage.setProperty(
	"column-1", "71_INSTANCE_uxxsIbKD2cfQ,");

layoutRSS.setTypeSettingsProperties(typeSettingsPropertiesRSSPage);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutRSS.getLayoutId(),
	layoutRSS.getTypeSettings());

UnicodeProperties propertiesRSS = new UnicodeProperties();

propertiesRSS.setProperty("displayStyle", "from-level-0");
propertiesRSS.setProperty("headerType", "root-layout");
propertiesRSS.setProperty("bulletStyle", "dots");
propertiesRSS.setProperty("rootLayoutType", "absolute");
propertiesRSS.setProperty("includedLayouts", "auto");
propertiesRSS.setProperty("nestedChildren", "1");
propertiesRSS.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceRSS", "71_INSTANCE_uxxsIbKD2cfQ");

portletResourceRSS = (String)actionRequest.getAttribute("portletResourceRSS");

PortletPreferences portletPreferencesRSSPage =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceRSS);

for (Map.Entry<String, String> entry : propertiesRSS.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesRSSPage.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutRSS.getPlid(), "71_INSTANCE_uxxsIbKD2cfQ",
	portletPreferencesRSSPage);
