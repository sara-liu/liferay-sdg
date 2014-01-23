import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;

import javax.portlet.PortletPreferences;

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

userId = PortalUtil.getUserId(actionRequest);

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	actionRequest);

serviceContext.setScopeGroupId(groupId);

// Tools

Layout toolsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Tools", "", "", "link_to_layout", false,
	"/tools", serviceContext);

// Dictionary

Layout dictionaryLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, toolsLayout.getLayoutId(), "Dictionary", "", "",
	"portlet", false, "/dictionary", serviceContext);

LayoutTypePortlet dictionaryLayoutTypePortlet =
	(LayoutTypePortlet)dictionaryLayout.getLayoutType();

dictionaryLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ToolsSM00001", "column-1", -1, false);
dictionaryLayoutTypePortlet.addPortletId(userId, "23", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, dictionaryLayout.getLayoutId(),
	dictionaryLayout.getTypeSettings());

// Language

Layout languageLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, toolsLayout.getLayoutId(), "Language Portlet", "",
	"", "portlet", false, "/language-portlet", serviceContext);

LayoutTypePortlet languageLayoutTypePortlet =
	(LayoutTypePortlet)languageLayout.getLayoutType();

languageLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ToolsSM00002", "column-1", -1, false);
languageLayoutTypePortlet.addPortletId(userId, "82", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, languageLayout.getLayoutId(),
	languageLayout.getTypeSettings());

// Network Utilities

Layout networkUtilitiesLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, toolsLayout.getLayoutId(), "Network Utilities", "",
	"", "portlet", false, "/network-utilities", serviceContext);

LayoutTypePortlet networkUtilitiesLayoutTypePortlet =
	(LayoutTypePortlet)networkUtilitiesLayout.getLayoutType();

networkUtilitiesLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ToolsSM00003", "column-1", -1, false);
networkUtilitiesLayoutTypePortlet.addPortletId(
	userId, "30", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, networkUtilitiesLayout.getLayoutId(),
	networkUtilitiesLayout.getTypeSettings());

// Password Generator

Layout passwordGenertorLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, toolsLayout.getLayoutId(), "Password Generator", "",
	"", "portlet", false, "/password-generator", serviceContext);

LayoutTypePortlet passwordGeneratorLayoutTypePortlet =
	(LayoutTypePortlet)passwordGenertorLayout.getLayoutType();

passwordGeneratorLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ToolsSM00004", "column-1", -1, false);
passwordGeneratorLayoutTypePortlet.addPortletId(
	userId, "70", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, passwordGenertorLayout.getLayoutId(),
	passwordGenertorLayout.getTypeSettings());

// Quick Note

Layout quickNoteLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, toolsLayout.getLayoutId(), "Quick Note", "", "",
	"portlet", false, "/quick-note", serviceContext);

LayoutTypePortlet quickNoteLayoutTypePortlet =
	(LayoutTypePortlet)quickNoteLayout.getLayoutType();

quickNoteLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ToolsSM00005", "column-1", -1, false);
quickNoteLayoutTypePortlet.addPortletId(
	userId, "97_INSTANCE_ToolsQN00001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, quickNoteLayout.getLayoutId(),
	quickNoteLayout.getTypeSettings());

PortletPreferences quickNotePortletPreferences =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		quickNoteLayout.getPlid(), "97_INSTANCE_ToolsQN00001",
		PortletConstants.DEFAULT_PREFERENCES);

quickNotePortletPreferences.setValue(
	"data", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed " +
		" do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, quickNoteLayout.getPlid(),
	"97_INSTANCE_ToolsQN00001", quickNotePortletPreferences);

// Search

Layout searchLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, toolsLayout.getLayoutId(), "Search", "", "",
	"portlet", false, "/search", serviceContext);

LayoutTypePortlet searchLayoutTypePortlet =
	(LayoutTypePortlet)searchLayout.getLayoutType();

searchLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ToolsSM00006", "column-1", -1, false);
searchLayoutTypePortlet.addPortletId(userId, "3", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, searchLayout.getLayoutId(), searchLayout.getTypeSettings());

// Translator

Layout translatorLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, toolsLayout.getLayoutId(), "Translator", "", "",
	"portlet", false, "/translator", serviceContext);

LayoutTypePortlet translatorLayoutTypePortlet =
	(LayoutTypePortlet)translatorLayout.getLayoutType();

translatorLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ToolsSM00007", "column-1", -1, false);
translatorLayoutTypePortlet.addPortletId(userId, "26", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, translatorLayout.getLayoutId(),
	translatorLayout.getTypeSettings());

// Unit Converter

Layout unitConverterLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, toolsLayout.getLayoutId(), "Unit Converter", "", "",
	"portlet", false, "/unit-converter", serviceContext);

LayoutTypePortlet unitConverterLayoutTypePortlet =
	(LayoutTypePortlet)unitConverterLayout.getLayoutType();

unitConverterLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ToolsSM00008", "column-1", -1, false);
unitConverterLayoutTypePortlet.addPortletId(
	userId, "27", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, unitConverterLayout.getLayoutId(),
	unitConverterLayout.getTypeSettings());

// Link parent page with first child page

UnicodeProperties toolsTypeSettingsProperties =
	toolsLayout.getTypeSettingsProperties();

toolsTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(dictionaryLayout.getLayoutId()));

toolsLayout.setTypeSettingsProperties(toolsTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, toolsLayout.getLayoutId(), toolsLayout.getTypeSettings());