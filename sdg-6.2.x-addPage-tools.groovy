import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;

import java.util.HashMap;
import java.util.Locale;

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


// Add tools part

Map<Locale, String> nameMapTools = new HashMap<Locale, String>();

nameMapTools.put(Locale.US, "Tools");

Map<Locale, String> titleMapTools = new HashMap<Locale, String>();

titleMapTools.put(Locale.US, "");

Map<Locale, String> descriptionMapTools = new HashMap<Locale, String>();

descriptionMapTools.put(Locale.US, "");

Map<Locale, String> keywordsMapTools = new HashMap<Locale, String>();

keywordsMapTools.put(Locale.US, "");

Map<Locale, String> robotsMapTools = new HashMap<Locale, String>();

robotsMapTools.put(Locale.US, "");

Map<Locale, String> friendlyURLMapTools = new HashMap<Locale, String>();

friendlyURLMapTools.put(Locale.US, "/tools");

Layout layoutTools = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapTools, titleMapTools,
	descriptionMapTools, keywordsMapTools, robotsMapTools,
	"link_to_layout", null, false, friendlyURLMapTools, serviceContext);

layoutToolsId = layoutTools.getLayoutId();

Map<Locale, String> nameMapDictionary = new HashMap<Locale, String>();

nameMapDictionary.put(Locale.US, "Dictionary");

Map<Locale, String> titleMapDictionary = new HashMap<Locale, String>();

titleMapDictionary.put(Locale.US, "");

Map<Locale, String> descriptionMapDictionary = new HashMap<Locale, String>();

descriptionMapDictionary.put(Locale.US, "");

Map<Locale, String> keywordsMapDictionary = new HashMap<Locale, String>();

keywordsMapDictionary.put(Locale.US, "");

Map<Locale, String> robotsMapDictionary = new HashMap<Locale, String>();

robotsMapDictionary.put(Locale.US, "");

Map<Locale, String> friendlyURLMapDictionary = new HashMap<Locale, String>();

friendlyURLMapDictionary.put(Locale.US, "/dictionary");

Layout layoutDictionary = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapDictionary,
	titleMapDictionary, descriptionMapDictionary, keywordsMapDictionary,
	robotsMapDictionary, "portlet", null, false, friendlyURLMapDictionary,
	serviceContext);

Map<Locale, String> nameMapLanguageP = new HashMap<Locale, String>();

nameMapLanguageP.put(Locale.US, "Language Portlet");

Map<Locale, String> titleMapLanguageP = new HashMap<Locale, String>();

titleMapLanguageP.put(Locale.US, "");

Map<Locale, String> descriptionMapLanguageP = new HashMap<Locale, String>();

descriptionMapLanguageP.put(Locale.US, "");

Map<Locale, String> keywordsMapLanguageP = new HashMap<Locale, String>();

keywordsMapLanguageP.put(Locale.US, "");

Map<Locale, String> robotsMapLanguageP = new HashMap<Locale, String>();

robotsMapLanguageP.put(Locale.US, "");

Map<Locale, String> friendlyURLMapLanguageP = new HashMap<Locale, String>();

friendlyURLMapLanguageP.put(Locale.US, "/language-portlet");

Layout layoutLanguageP = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapLanguageP,
	titleMapLanguageP, descriptionMapLanguageP, keywordsMapLanguageP,
	robotsMapLanguageP, "portlet", null, false, friendlyURLMapLanguageP,
	serviceContext);

Map<Locale, String> nameMapNetworkU = new HashMap<Locale, String>();

nameMapNetworkU.put(Locale.US, "Network Utilities");

Map<Locale, String> titleMapNetworkU = new HashMap<Locale, String>();

titleMapNetworkU.put(Locale.US, "");

Map<Locale, String> descriptionMapNetworkU = new HashMap<Locale, String>();

descriptionMapNetworkU.put(Locale.US, "");

Map<Locale, String> keywordsMapNetworkU = new HashMap<Locale, String>();

keywordsMapNetworkU.put(Locale.US, "");

Map<Locale, String> robotsMapNetworkU = new HashMap<Locale, String>();

robotsMapNetworkU.put(Locale.US, "");

Map<Locale, String> friendlyURLMapNetworkU = new HashMap<Locale, String>();

friendlyURLMapNetworkU.put(Locale.US, "/network-utilities");

Layout layoutNetworkU = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapNetworkU,
	titleMapNetworkU, descriptionMapNetworkU, keywordsMapNetworkU,
	robotsMapNetworkU, "portlet", null, false, friendlyURLMapNetworkU,
	serviceContext);

Map<Locale, String> nameMapPG = new HashMap<Locale, String>();

nameMapPG.put(Locale.US, "Password Generator");

Map<Locale, String> titleMapPG = new HashMap<Locale, String>();

titleMapPG.put(Locale.US, "");

Map<Locale, String> descriptionMapPG = new HashMap<Locale, String>();

descriptionMapPG.put(Locale.US, "");

Map<Locale, String> keywordsMapPG = new HashMap<Locale, String>();

keywordsMapPG.put(Locale.US, "");

Map<Locale, String> robotsMapPG = new HashMap<Locale, String>();

robotsMapPG.put(Locale.US, "");

Map<Locale, String> friendlyURLMapPG = new HashMap<Locale, String>();

friendlyURLMapPG.put(Locale.US, "/password-generator");

Layout layoutPG = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapPG, titleMapPG,
	descriptionMapPG, keywordsMapPG, robotsMapPG, "portlet", null,
	false, friendlyURLMapPG, serviceContext);

Map<Locale, String> nameMapQN = new HashMap<Locale, String>();

nameMapQN.put(Locale.US, "Quick Note");

Map<Locale, String> titleMapQN = new HashMap<Locale, String>();

titleMapQN.put(Locale.US, "");

Map<Locale, String> descriptionMapQN = new HashMap<Locale, String>();

descriptionMapQN.put(Locale.US, "");

Map<Locale, String> keywordsMapQN = new HashMap<Locale, String>();

keywordsMapQN.put(Locale.US, "");

Map<Locale, String> robotsMapQN = new HashMap<Locale, String>();

robotsMapQN.put(Locale.US, "");

Map<Locale, String> friendlyURLMapQN = new HashMap<Locale, String>();

friendlyURLMapQN.put(Locale.US, "/quick-note");

Layout layoutQN = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapQN, titleMapQN,
	descriptionMapQN, keywordsMapQN, robotsMapQN, "portlet", null, false,
	friendlyURLMapQN, serviceContext);

Map<Locale, String> nameMapSearch = new HashMap<Locale, String>();

nameMapSearch.put(Locale.US, "Search");

Map<Locale, String> titleMapSearch = new HashMap<Locale, String>();

titleMapSearch.put(Locale.US, "");

Map<Locale, String> descriptionMapSearch = new HashMap<Locale, String>();

descriptionMapSearch.put(Locale.US, "");

Map<Locale, String> keywordsMapSearch = new HashMap<Locale, String>();

keywordsMapSearch.put(Locale.US, "");

Map<Locale, String> robotsMapSearch = new HashMap<Locale, String>();

robotsMapSearch.put(Locale.US, "");

Map<Locale, String> friendlyURLMapSearch = new HashMap<Locale, String>();

friendlyURLMapSearch.put(Locale.US, "/search");

Layout layoutSearch = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapSearch, titleMapSearch,
	descriptionMapSearch, keywordsMapSearch, robotsMapSearch, "portlet",
	null, false, friendlyURLMapSearch, serviceContext);

Map<Locale, String> nameMapSIn = new HashMap<Locale, String>();

nameMapSIn.put(Locale.US, "Sign In");

Map<Locale, String> titleMapSIn = new HashMap<Locale, String>();

titleMapSIn.put(Locale.US, "");

Map<Locale, String> descriptionMapSIn = new HashMap<Locale, String>();

descriptionMapSIn.put(Locale.US, "");

Map<Locale, String> keywordsMapSIn = new HashMap<Locale, String>();

keywordsMapSIn.put(Locale.US, "");

Map<Locale, String> robotsMapSIn = new HashMap<Locale, String>();

robotsMapSIn.put(Locale.US, "");

Map<Locale, String> friendlyURLMapSIn = new HashMap<Locale, String>();

friendlyURLMapSIn.put(Locale.US, "/sign-in");

Layout layoutSIn = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapSIn, titleMapSIn,
	descriptionMapSIn, keywordsMapSIn, robotsMapSIn, "portlet", null, false,
	friendlyURLMapSIn, serviceContext);

Map<Locale, String> nameMapSoftwareC = new HashMap<Locale, String>();

nameMapSoftwareC.put(Locale.US, "Software Catalog");

Map<Locale, String> titleMapSoftwareC = new HashMap<Locale, String>();

titleMapSoftwareC.put(Locale.US, "");

Map<Locale, String> descriptionMapSoftwareC = new HashMap<Locale, String>();

descriptionMapSoftwareC.put(Locale.US, "");

Map<Locale, String> keywordsMapSoftwareC = new HashMap<Locale, String>();

keywordsMapSoftwareC.put(Locale.US, "");

Map<Locale, String> robotsMapSoftwareC = new HashMap<Locale, String>();

robotsMapSoftwareC.put(Locale.US, "");

Map<Locale, String> friendlyURLMapSoftwareC = new HashMap<Locale, String>();

friendlyURLMapSoftwareC.put(Locale.US, "/software-catalog");

Layout layoutSoftwareC = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapSoftwareC,
	titleMapSoftwareC, descriptionMapSoftwareC, keywordsMapSoftwareC,
	robotsMapSoftwareC, "portlet", null, false, friendlyURLMapSoftwareC,
	serviceContext);

Map<Locale, String> nameMapTranslator = new HashMap<Locale, String>();

nameMapTranslator.put(Locale.US, "Translator");

Map<Locale, String> titleMapTranslator = new HashMap<Locale, String>();

titleMapTranslator.put(Locale.US, "");

Map<Locale, String> descriptionMapTranslator = new HashMap<Locale, String>();

descriptionMapTranslator.put(Locale.US, "");

Map<Locale, String> keywordsMapTranslator = new HashMap<Locale, String>();

keywordsMapTranslator.put(Locale.US, "");

Map<Locale, String> robotsMapTranslator = new HashMap<Locale, String>();

robotsMapTranslator.put(Locale.US, "");

Map<Locale, String> friendlyURLMapTranslator = new HashMap<Locale, String>();

friendlyURLMapTranslator.put(Locale.US, "/translator");

Layout layoutTranslator = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapTranslator,
	titleMapTranslator, descriptionMapTranslator, keywordsMapTranslator,
	robotsMapTranslator, "portlet", null, false, friendlyURLMapTranslator,
	serviceContext);

Map<Locale, String> nameMapUC = new HashMap<Locale, String>();

nameMapUC.put(Locale.US, "Unit Converter");

Map<Locale, String> titleMapUC = new HashMap<Locale, String>();

titleMapUC.put(Locale.US, "");

Map<Locale, String> descriptionMapUC = new HashMap<Locale, String>();

descriptionMapUC.put(Locale.US, "");

Map<Locale, String> keywordsMapUC = new HashMap<Locale, String>();

keywordsMapUC.put(Locale.US, "");

Map<Locale, String> robotsMapUC = new HashMap<Locale, String>();

robotsMapUC.put(Locale.US, "");

Map<Locale, String> friendlyURLMapUC = new HashMap<Locale, String>();

friendlyURLMapUC.put(Locale.US, "/unit-converter");

Layout layoutUC = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapUC, titleMapUC,
	descriptionMapUC, keywordsMapUC, robotsMapUC, "portlet", null, false,
	friendlyURLMapUC, serviceContext);

// Tools page links to dictionary page.

UnicodeProperties typeSettingsPropertiesTools =
	layoutTools.getTypeSettingsProperties();

typeSettingsPropertiesTools.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesTools.setProperty("show-alternate-links", "true");
typeSettingsPropertiesTools.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesTools.setProperty(
	"linkToLayoutId", String.valueOf(layoutDictionary.getLayoutId()));
typeSettingsPropertiesTools.setProperty("sitemap-include", "1");
typeSettingsPropertiesTools.setProperty("layout-template-id", "2_columns_ii");

layoutTools.setTypeSettingsProperties(typeSettingsPropertiesTools);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutToolsId, layoutTools.getTypeSettings());
