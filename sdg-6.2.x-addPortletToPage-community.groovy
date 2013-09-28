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

// Bookmarks page

Layout layoutBookmarks = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/bookmarks");

UnicodeProperties typeSettingsPropertiesBookmark =
	layoutBookmarks.getTypeSettingsProperties();

typeSettingsPropertiesBookmark.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesBookmark.setProperty("column-2", "28");
typeSettingsPropertiesBookmark.setProperty("column-1", "71_INSTANCE_7VL6SLQvAQyJ,");

layoutBookmarks.setTypeSettingsProperties(typeSettingsPropertiesBookmark);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutBookmarks.getLayoutId(),
	layoutBookmarks.getTypeSettings());

UnicodeProperties propertiesBookmark = new UnicodeProperties();

propertiesBookmark.setProperty("displayStyle", "from-level-0");
propertiesBookmark.setProperty("headerType", "root-layout");
propertiesBookmark.setProperty("bulletStyle", "dots");
propertiesBookmark.setProperty("rootLayoutType", "absolute");
propertiesBookmark.setProperty("includedLayouts", "auto");
propertiesBookmark.setProperty("nestedChildren", "1");
propertiesBookmark.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceBookmark", "71_INSTANCE_7VL6SLQvAQyJ");

portletResourceBookmark = (String)actionRequest.getAttribute(
	"portletResourceBookmark");

PortletPreferences portletPreferencesBookmark =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceBookmark);

for (Map.Entry<String, String> entry : propertiesBookmark.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesBookmark.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutBookmarks.getPlid(), "71_INSTANCE_7VL6SLQvAQyJ",
	portletPreferencesBookmark);

// Friends directory page

Layout layoutFD = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/friends-directory");

UnicodeProperties typeSettingsPropertiesFD =
	layoutFD.getTypeSettingsProperties();

typeSettingsPropertiesFD.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesFD.setProperty("column-2", "186");
typeSettingsPropertiesFD.setProperty("column-1", "71_INSTANCE_HwcVOI17WGQx,");

layoutFD.setTypeSettingsProperties(typeSettingsPropertiesFD);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutFD.getLayoutId(),
	layoutFD.getTypeSettings());

UnicodeProperties propertiesFD = new UnicodeProperties();

propertiesFD.setProperty("displayStyle", "from-level-0");
propertiesFD.setProperty("headerType", "root-layout");
propertiesFD.setProperty("bulletStyle", "dots");
propertiesFD.setProperty("rootLayoutType", "absolute");
propertiesFD.setProperty("includedLayouts", "auto");
propertiesFD.setProperty("nestedChildren", "1");
propertiesFD.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceFD", "71_INSTANCE_HwcVOI17WGQx");

portletResourceFD = (String)actionRequest.getAttribute("portletResourceFD");

PortletPreferences portletPreferencesFD =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceFD);

for (Map.Entry<String, String> entry : propertiesFD.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesFD.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutFD.getPlid(), "71_INSTANCE_HwcVOI17WGQx",
	portletPreferencesFD);

// Invitation page

Layout layoutInvitation = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/invitation");

UnicodeProperties typeSettingsPropertiesInvitation =
	layoutInvitation.getTypeSettingsProperties();

typeSettingsPropertiesInvitation.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesInvitation.setProperty("column-2", "100");
typeSettingsPropertiesInvitation.setProperty("column-1", "71_INSTANCE_HwcVOI17WGQm,");

layoutInvitation.setTypeSettingsProperties(typeSettingsPropertiesInvitation);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutInvitation.getLayoutId(),
	layoutInvitation.getTypeSettings());

UnicodeProperties propertiesInvitation = new UnicodeProperties();

propertiesInvitation.setProperty("displayStyle", "from-level-0");
propertiesInvitation.setProperty("headerType", "root-layout");
propertiesInvitation.setProperty("bulletStyle", "dots");
propertiesInvitation.setProperty("rootLayoutType", "absolute");
propertiesInvitation.setProperty("includedLayouts", "auto");
propertiesInvitation.setProperty("nestedChildren", "1");
propertiesInvitation.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceInvitation", "71_INSTANCE_HwcVOI17WGQm");

portletResourceInvitation = (String)actionRequest.getAttribute(
	"portletResourceInvitation");

PortletPreferences portletPreferencesInvitation =
	PortletPreferencesFactoryUtil.getPortletSetup(
	actionRequest, portletResourceInvitation);

for (Map.Entry<String, String> entry : propertiesInvitation.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesInvitation.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutInvitation.getPlid(), "71_INSTANCE_HwcVOI17WGQm",
	portletPreferencesInvitation);

// My site page

Layout layoutMSite = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/my-site");

UnicodeProperties typeSettingsPropertiesMSite =
	layoutMSite.getTypeSettingsProperties();

typeSettingsPropertiesMSite.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesMSite.setProperty("column-2", "29");
typeSettingsPropertiesMSite.setProperty("column-1", "71_INSTANCE_JfIkBcsg8840,");

layoutMSite.setTypeSettingsProperties(typeSettingsPropertiesMSite);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutMSite.getLayoutId(),
	layoutMSite.getTypeSettings());

UnicodeProperties propertiesMSite = new UnicodeProperties();

propertiesMSite.setProperty("displayStyle", "from-level-0");
propertiesMSite.setProperty("headerType", "root-layout");
propertiesMSite.setProperty("bulletStyle", "dots");
propertiesMSite.setProperty("rootLayoutType", "absolute");
propertiesMSite.setProperty("includedLayouts", "auto");
propertiesMSite.setProperty("nestedChildren", "1");
propertiesMSite.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceMSite", "71_INSTANCE_JfIkBcsg8840");

portletResourceMSite = (String)actionRequest.getAttribute(
	"portletResourceMSite");

PortletPreferences portletPreferencesMSite =
	PortletPreferencesFactoryUtil.getPortletSetup(
	actionRequest, portletResourceMSite);

for (Map.Entry<String, String> entry : propertiesMSite.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesMSite.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutMSite.getPlid(), "71_INSTANCE_JfIkBcsg8840",
	portletPreferencesMSite);

// Page comment page

Layout layoutPComment = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/page-comments");

UnicodeProperties typeSettingsPropertiesPComment =
	layoutPComment.getTypeSettingsProperties();

typeSettingsPropertiesPComment.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesPComment.setProperty("column-2", "108,107,143");
typeSettingsPropertiesPComment.setProperty("column-1", "71_INSTANCE_mK2L1tZReQ4h,");

layoutPComment.setTypeSettingsProperties(typeSettingsPropertiesPComment);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutPComment.getLayoutId(),
	layoutPComment.getTypeSettings());

UnicodeProperties propertiesPComment = new UnicodeProperties();

propertiesPComment.setProperty("displayStyle", "from-level-0");
propertiesPComment.setProperty("headerType", "root-layout");
propertiesPComment.setProperty("bulletStyle", "dots");
propertiesPComment.setProperty("rootLayoutType", "absolute");
propertiesPComment.setProperty("includedLayouts", "auto");
propertiesPComment.setProperty("nestedChildren", "1");
propertiesPComment.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourcePComment", "71_INSTANCE_mK2L1tZReQ4h");

portletResourcePComment = (String)actionRequest.getAttribute(
	"portletResourcePComment");

PortletPreferences portletPreferencesPComment =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourcePComment);

for (Map.Entry<String, String> entry : propertiesPComment.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesPComment.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutPComment.getPlid(), "71_INSTANCE_mK2L1tZReQ4h",
	portletPreferencesPComment);

// Portal directory page

Layout layoutPDirectory = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/portal-directory");

UnicodeProperties typeSettingsPropertiesPDirectory =
	layoutPDirectory.getTypeSettingsProperties();

typeSettingsPropertiesPDirectory.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesPDirectory.setProperty("column-2", "187,11");
typeSettingsPropertiesPDirectory.setProperty("column-1", "71_INSTANCE_uixmz2y3dFa6,");

layoutPDirectory.setTypeSettingsProperties(typeSettingsPropertiesPDirectory);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutPDirectory.getLayoutId(),
	layoutPDirectory.getTypeSettings());

UnicodeProperties propertiesPDirectory = new UnicodeProperties();

propertiesPDirectory.setProperty("displayStyle", "from-level-0");
propertiesPDirectory.setProperty("headerType", "root-layout");
propertiesPDirectory.setProperty("bulletStyle", "dots");
propertiesPDirectory.setProperty("rootLayoutType", "absolute");
propertiesPDirectory.setProperty("includedLayouts", "auto");
propertiesPDirectory.setProperty("nestedChildren", "1");
propertiesPDirectory.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourcePDirectory", "71_INSTANCE_uixmz2y3dFa6");

portletResourcePDirectory = (String)actionRequest.getAttribute(
	"portletResourcePDirectory");

PortletPreferences portletPreferencesPDirectory =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourcePDirectory);

for (Map.Entry<String, String> entry : propertiesPDirectory.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesPDirectory.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutPDirectory.getPlid(), "71_INSTANCE_uixmz2y3dFa6",
	portletPreferencesPDirectory);
