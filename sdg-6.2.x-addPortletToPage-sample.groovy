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

// Hello velocity page

Layout layoutHV = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/hello-velocity");

UnicodeProperties typeSettingsPropertiesHV =
	layoutHV.getTypeSettingsProperties();

typeSettingsPropertiesHV.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesHV.setProperty("column-2", "50");
typeSettingsPropertiesHV.setProperty("column-1", "71_INSTANCE_pfxMm9207AWV,");

layoutHV.setTypeSettingsProperties(typeSettingsPropertiesHV);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutHV.getLayoutId(),
	layoutHV.getTypeSettings());

UnicodeProperties propertiesHV = new UnicodeProperties();

propertiesHV.setProperty("displayStyle", "from-level-0");
propertiesHV.setProperty("headerType", "root-layout");
propertiesHV.setProperty("bulletStyle", "dots");
propertiesHV.setProperty("rootLayoutType", "absolute");
propertiesHV.setProperty("includedLayouts", "auto");
propertiesHV.setProperty("nestedChildren", "1");
propertiesHV.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceHV", "71_INSTANCE_pfxMm9207AWV");

portletResourceHV = (String)actionRequest.getAttribute("portletResourceHV");

PortletPreferences portletPreferencesHV =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceHV);

for (Map.Entry<String, String> entry : propertiesHV.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesHV.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutHV.getPlid(), "71_INSTANCE_pfxMm9207AWV",
	portletPreferencesHV);

// Hello world page

Layout layoutHW = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/hello-world");

UnicodeProperties typeSettingsPropertiesHW =
	layoutHW.getTypeSettingsProperties();

typeSettingsPropertiesHW.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesHW.setProperty("column-2", "47");
typeSettingsPropertiesHW.setProperty("column-1", "71_INSTANCE_bs3KJ4i88GbQ,");

layoutHW.setTypeSettingsProperties(typeSettingsPropertiesHW);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutHW.getLayoutId(),
	layoutHW.getTypeSettings());

UnicodeProperties propertiesHW = new UnicodeProperties();

propertiesHW.setProperty("displayStyle", "from-level-0");
propertiesHW.setProperty("headerType", "root-layout");
propertiesHW.setProperty("bulletStyle", "dots");
propertiesHW.setProperty("rootLayoutType", "absolute");
propertiesHW.setProperty("includedLayouts", "auto");
propertiesHW.setProperty("nestedChildren", "1");
propertiesHW.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceHW", "71_INSTANCE_bs3KJ4i88GbQ");

portletResourceHW = (String)actionRequest.getAttribute("portletResourceHW");

PortletPreferences portletPreferencesHW =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceHW);

for (Map.Entry<String, String> entry : propertiesHW.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesHW.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutHW.getPlid(), "71_INSTANCE_bs3KJ4i88GbQ",
	portletPreferencesHW);

// IFrame page

Layout layoutIFrame = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/iFrame");

UnicodeProperties typeSettingsPropertiesIFramePage =
	layoutIFrame.getTypeSettingsProperties();

typeSettingsPropertiesIFramePage.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesIFramePage.setProperty(
	"column-2", "48_INSTANCE_mpN1u52gzmbO");
typeSettingsPropertiesIFramePage.setProperty(
	"column-1", "71_INSTANCE_5tPfn8V7Z2Sy,");

layoutIFrame.setTypeSettingsProperties(typeSettingsPropertiesIFramePage);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutIFrame.getLayoutId(),
	layoutIFrame.getTypeSettings());

UnicodeProperties propertiesIFrame = new UnicodeProperties();

propertiesIFrame.setProperty("displayStyle", "from-level-0");
propertiesIFrame.setProperty("headerType", "root-layout");
propertiesIFrame.setProperty("bulletStyle", "dots");
propertiesIFrame.setProperty("rootLayoutType", "absolute");
propertiesIFrame.setProperty("includedLayouts", "auto");
propertiesIFrame.setProperty("nestedChildren", "1");
propertiesIFrame.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceIFrame", "71_INSTANCE_5tPfn8V7Z2Sy");

portletResourceIFrame = (String)actionRequest.getAttribute(
	"portletResourceIFrame");

PortletPreferences portletPreferencesIFramePage =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceIFrame);

for (Map.Entry<String, String> entry : propertiesIFrame.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesIFramePage.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutIFrame.getPlid(), "71_INSTANCE_5tPfn8V7Z2Sy",
	portletPreferencesIFramePage);

// Web proxy page

Layout layoutWebP = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/web-proxy");

UnicodeProperties typeSettingsPropertiesWebP =
	layoutWebP.getTypeSettingsProperties();

typeSettingsPropertiesWebP.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesWebP.setProperty("column-2", "66_INSTANCE_BM7GHtVBl6df");
typeSettingsPropertiesWebP.setProperty(
	"column-1", "71_INSTANCE_y5f1MxkIhKvm,");

layoutWebP.setTypeSettingsProperties(typeSettingsPropertiesWebP);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutWebP.getLayoutId(),
	layoutWebP.getTypeSettings());

UnicodeProperties propertiesWebP = new UnicodeProperties();

propertiesWebP.setProperty("displayStyle", "from-level-0");
propertiesWebP.setProperty("headerType", "root-layout");
propertiesWebP.setProperty("bulletStyle", "dots");
propertiesWebP.setProperty("rootLayoutType", "absolute");
propertiesWebP.setProperty("includedLayouts", "auto");
propertiesWebP.setProperty("nestedChildren", "1");
propertiesWebP.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceWebP", "71_INSTANCE_y5f1MxkIhKvm");

portletResourceWebP = (String)actionRequest.getAttribute(
	"portletResourceWebP");

PortletPreferences portletPreferencesWebP =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceWebP);

for (Map.Entry<String, String> entry : propertiesWebP.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesWebP.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutWebP.getPlid(), "71_INSTANCE_y5f1MxkIhKvm",
	portletPreferencesWebP);
