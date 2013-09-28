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

// Blogs page

Layout layoutBlogs = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/blogs");

UnicodeProperties typeSettingsPropertiesBlog =
	layoutBlogs.getTypeSettingsProperties();

typeSettingsPropertiesBlog.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesBlog.setProperty("column-1", "71_INSTANCE_rETjYe1irD4L");
typeSettingsPropertiesBlog.setProperty("column-2", "115,33,114");

layoutBlogs.setTypeSettingsProperties(typeSettingsPropertiesBlog);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutBlogs.getLayoutId(),
	layoutBlogs.getTypeSettings());

UnicodeProperties propertiesBlog = new UnicodeProperties();

propertiesBlog.setProperty("displayStyle", "from-level-0");
propertiesBlog.setProperty("headerType", "root-layout");
propertiesBlog.setProperty("bulletStyle", "dots");
propertiesBlog.setProperty("rootLayoutType", "absolute");
propertiesBlog.setProperty("includedLayouts", "auto");
propertiesBlog.setProperty("nestedChildren", "1");
propertiesBlog.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceBlog", "71_INSTANCE_rETjYe1irD4L");

portletResourceBlog = (String)actionRequest.getAttribute("portletResourceBlog");

PortletPreferences portletPreferencesBlog =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceBlog);

for (Map.Entry<String, String> entry : propertiesBlog.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesBlog.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutBlogs.getPlid(), "71_INSTANCE_rETjYe1irD4L",
	portletPreferencesBlog);

// Dynamic data page

Layout layoutDD = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/dynamic-data");

UnicodeProperties typeSettingsPropertiesDD =
	layoutDD.getTypeSettingsProperties();

typeSettingsPropertiesDD.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesDD.setProperty("column-1", "71_INSTANCE_cpWOAkKlrbl2");
typeSettingsPropertiesDD.setProperty("column-2", "169_INSTANCE_yOInr1Ynqt0S");

layoutDD.setTypeSettingsProperties(typeSettingsPropertiesDD);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutDD.getLayoutId(),
	layoutDD.getTypeSettings());

UnicodeProperties propertiesDD = new UnicodeProperties();

propertiesDD.setProperty("displayStyle", "from-level-0");
propertiesDD.setProperty("headerType", "root-layout");
propertiesDD.setProperty("bulletStyle", "dots");
propertiesDD.setProperty("rootLayoutType", "absolute");
propertiesDD.setProperty("includedLayouts", "auto");
propertiesDD.setProperty("nestedChildren", "1");
propertiesDD.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceDD", "71_INSTANCE_cpWOAkKlrbl2");

portletResourceDD = (String)actionRequest.getAttribute("portletResourceDD");

PortletPreferences portletPreferencesDD =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceDD);

for (Map.Entry<String, String> entry : propertiesDD.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesDD.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutDD.getPlid(), "71_INSTANCE_cpWOAkKlrbl2",
	portletPreferencesDD);

// Wiki page

Layout layoutWiki = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/wiki");

UnicodeProperties typeSettingsPropertiesWiki =
	layoutWiki.getTypeSettingsProperties();

typeSettingsPropertiesWiki.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesWiki.setProperty("column-1", "71_INSTANCE_cpWOAkKlrbl3");
typeSettingsPropertiesWiki.setProperty("column-2", "36");

layoutWiki.setTypeSettingsProperties(typeSettingsPropertiesWiki);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutWiki.getLayoutId(),
	layoutWiki.getTypeSettings());

UnicodeProperties propertiesWiki = new UnicodeProperties();

propertiesWiki.setProperty("displayStyle", "from-level-0");
propertiesWiki.setProperty("headerType", "root-layout");
propertiesWiki.setProperty("bulletStyle", "dots");
propertiesWiki.setProperty("rootLayoutType", "absolute");
propertiesWiki.setProperty("includedLayouts", "auto");
propertiesWiki.setProperty("nestedChildren", "1");
propertiesWiki.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceWiki", "71_INSTANCE_cpWOAkKlrbl3");

portletResourceWiki = (String)actionRequest.getAttribute("portletResourceWiki");

PortletPreferences portletPreferencesWiki =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceWiki);

for (Map.Entry<String, String> entry : propertiesWiki.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesWiki.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutWiki.getPlid(), "71_INSTANCE_cpWOAkKlrbl3",
	portletPreferencesWiki);

// Message board page

Layout layoutMB = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/message-board");

UnicodeProperties typeSettingsPropertiesMB =
	layoutMB.getTypeSettingsProperties();

typeSettingsPropertiesMB.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesMB.setProperty("column-1", "71_INSTANCE_vRgh12ulcIbj");
typeSettingsPropertiesMB.setProperty("column-2", "19");

layoutMB.setTypeSettingsProperties(typeSettingsPropertiesMB);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutMB.getLayoutId(),
	layoutMB.getTypeSettings());

UnicodeProperties propertiesMB = new UnicodeProperties();

propertiesMB.setProperty("displayStyle", "from-level-0");
propertiesMB.setProperty("headerType", "root-layout");
propertiesMB.setProperty("bulletStyle", "dots");
propertiesMB.setProperty("rootLayoutType", "absolute");
propertiesMB.setProperty("includedLayouts", "auto");
propertiesMB.setProperty("nestedChildren", "1");
propertiesMB.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceMB", "71_INSTANCE_vRgh12ulcIbj");

portletResourceMB = (String)actionRequest.getAttribute("portletResourceMB");

PortletPreferences portletPreferencesMB =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceMB);

for (Map.Entry<String, String> entry : propertiesMB.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesMB.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutMB.getPlid(), "71_INSTANCE_vRgh12ulcIbj",
	portletPreferencesMB);
