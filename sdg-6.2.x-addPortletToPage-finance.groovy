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

// Currency converter page

Layout layoutCC = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/currency-converter");

UnicodeProperties typeSettingsPropertiesCC =
	layoutCC.getTypeSettingsProperties();

typeSettingsPropertiesCC.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesCC.setProperty("column-2", "16");
typeSettingsPropertiesCC.setProperty("column-1", "71_INSTANCE_ah14nyR4ghXD,");

layoutCC.setTypeSettingsProperties(typeSettingsPropertiesCC);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutCC.getLayoutId(),
	layoutCC.getTypeSettings());

UnicodeProperties propertiesCC = new UnicodeProperties();

propertiesCC.setProperty("displayStyle", "from-level-0");
propertiesCC.setProperty("headerType", "root-layout");
propertiesCC.setProperty("bulletStyle", "dots");
propertiesCC.setProperty("rootLayoutType", "absolute");
propertiesCC.setProperty("includedLayouts", "auto");
propertiesCC.setProperty("nestedChildren", "1");
propertiesCC.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceCC", "71_INSTANCE_ah14nyR4ghXD");

portletResourceCC = (String)actionRequest.getAttribute("portletResourceCC");

PortletPreferences portletPreferencesCC =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceCC);

for (Map.Entry<String, String> entry : propertiesCC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesCC.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutCC.getPlid(), "71_INSTANCE_ah14nyR4ghXD",
	portletPreferencesCC);

// Loan calculator page

Layout layoutLC = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/loan-calculator");

UnicodeProperties typeSettingsPropertiesLC =
	layoutLC.getTypeSettingsProperties();

typeSettingsPropertiesLC.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesLC.setProperty("column-2", "61");
typeSettingsPropertiesLC.setProperty("column-1", "71_INSTANCE_ALJ5IzR8JFe3,");

layoutLC.setTypeSettingsProperties(typeSettingsPropertiesLC);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutLC.getLayoutId(),
	layoutLC.getTypeSettings());

UnicodeProperties propertiesLC = new UnicodeProperties();

propertiesLC.setProperty("displayStyle", "from-level-0");
propertiesLC.setProperty("headerType", "root-layout");
propertiesLC.setProperty("bulletStyle", "dots");
propertiesLC.setProperty("rootLayoutType", "absolute");
propertiesLC.setProperty("includedLayouts", "auto");
propertiesLC.setProperty("nestedChildren", "1");
propertiesLC.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceLC", "71_INSTANCE_ALJ5IzR8JFe3");

portletResourceLC = (String)actionRequest.getAttribute("portletResourceLC");

PortletPreferences portletPreferencesLC =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceLC);

for (Map.Entry<String, String> entry : propertiesLC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesLC.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutLC.getPlid(), "71_INSTANCE_ALJ5IzR8JFe3",
	portletPreferencesLC);
