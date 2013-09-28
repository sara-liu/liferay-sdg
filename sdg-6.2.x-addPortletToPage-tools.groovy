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

// Dictionary page

Layout layoutDictionary = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/dictionary");

UnicodeProperties typeSettingsPropertiesDictionary =
	layoutDictionary.getTypeSettingsProperties();

typeSettingsPropertiesDictionary.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesDictionary.setProperty("column-2", "23");
typeSettingsPropertiesDictionary.setProperty(
	"column-1", "71_INSTANCE_CUiKVFT7IRBd,");

layoutDictionary.setTypeSettingsProperties(typeSettingsPropertiesDictionary);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutDictionary.getLayoutId(),
	layoutDictionary.getTypeSettings());

UnicodeProperties propertiesDictionary = new UnicodeProperties();

propertiesDictionary.setProperty("displayStyle", "from-level-0");
propertiesDictionary.setProperty("headerType", "root-layout");
propertiesDictionary.setProperty("bulletStyle", "dots");
propertiesDictionary.setProperty("rootLayoutType", "absolute");
propertiesDictionary.setProperty("includedLayouts", "auto");
propertiesDictionary.setProperty("nestedChildren", "1");
propertiesDictionary.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceDictionary", "71_INSTANCE_CUiKVFT7IRBd");

portletResourceDictionary = (String)actionRequest.getAttribute(
	"portletResourceDictionary");

PortletPreferences portletPreferencesDictionary =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceDictionary);

for (Map.Entry<String, String> entry : propertiesDictionary.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesDictionary.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutDictionary.getPlid(), "71_INSTANCE_CUiKVFT7IRBd",
	portletPreferencesDictionary);

// Language portlet page

Layout layoutLanguageP = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/language-portlet");

UnicodeProperties typeSettingsPropertiesLanguageP =
	layoutLanguageP.getTypeSettingsProperties();

typeSettingsPropertiesLanguageP.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesLanguageP.setProperty("column-2", "82");
typeSettingsPropertiesLanguageP.setProperty(
	"column-1", "71_INSTANCE_7h25Ypo7Byd4,");

layoutLanguageP.setTypeSettingsProperties(typeSettingsPropertiesLanguageP);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutLanguageP.getLayoutId(),
	layoutLanguageP.getTypeSettings());

UnicodeProperties propertiesLanguageP = new UnicodeProperties();

propertiesLanguageP.setProperty("displayStyle", "from-level-0");
propertiesLanguageP.setProperty("headerType", "root-layout");
propertiesLanguageP.setProperty("bulletStyle", "dots");
propertiesLanguageP.setProperty("rootLayoutType", "absolute");
propertiesLanguageP.setProperty("includedLayouts", "auto");
propertiesLanguageP.setProperty("nestedChildren", "1");
propertiesLanguageP.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceLanguageP", "71_INSTANCE_7h25Ypo7Byd4");

portletResourceLanguageP = (String)actionRequest.getAttribute(
	"portletResourceLanguageP");

PortletPreferences portletPreferencesLanguageP =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceLanguageP);

for (Map.Entry<String, String> entry : propertiesLanguageP.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesLanguageP.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutLanguageP.getPlid(), "71_INSTANCE_7h25Ypo7Byd4",
	portletPreferencesLanguageP);

// Network utilities page

Layout layoutNetworkU = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/network-utilities");

UnicodeProperties typeSettingsPropertiesNetworkU =
	layoutNetworkU.getTypeSettingsProperties();

typeSettingsPropertiesNetworkU.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesNetworkU.setProperty("column-2", "30");
typeSettingsPropertiesNetworkU.setProperty(
	"column-1", "71_INSTANCE_rT4G4vSmVqOL,");

layoutNetworkU.setTypeSettingsProperties(typeSettingsPropertiesNetworkU);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutNetworkU.getLayoutId(),
	layoutNetworkU.getTypeSettings());

UnicodeProperties propertiesNetworkU = new UnicodeProperties();

propertiesNetworkU.setProperty("displayStyle", "from-level-0");
propertiesNetworkU.setProperty("headerType", "root-layout");
propertiesNetworkU.setProperty("bulletStyle", "dots");
propertiesNetworkU.setProperty("rootLayoutType", "absolute");
propertiesNetworkU.setProperty("includedLayouts", "auto");
propertiesNetworkU.setProperty("nestedChildren", "1");
propertiesNetworkU.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceNetworkU", "71_INSTANCE_rT4G4vSmVqOL");

portletResourceNetworkU = (String)actionRequest.getAttribute(
	"portletResourceNetworkU");

PortletPreferences portletPreferencesNetworkU =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceNetworkU);

for (Map.Entry<String, String> entry : propertiesNetworkU.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesNetworkU.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutNetworkU.getPlid(), "71_INSTANCE_rT4G4vSmVqOL",
	portletPreferencesNetworkU);

// Password generator page

Layout layoutPG = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/password-generator");

UnicodeProperties typeSettingsPropertiesPG =
	layoutPG.getTypeSettingsProperties();

typeSettingsPropertiesPG.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesPG.setProperty("column-2", "70");
typeSettingsPropertiesPG.setProperty("column-1", "71_INSTANCE_U1NyroFwJGZ4,");

layoutPG.setTypeSettingsProperties(typeSettingsPropertiesPG);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutPG.getLayoutId(),
	layoutPG.getTypeSettings());

UnicodeProperties propertiesPG = new UnicodeProperties();

propertiesPG.setProperty("displayStyle", "from-level-0");
propertiesPG.setProperty("headerType", "root-layout");
propertiesPG.setProperty("bulletStyle", "dots");
propertiesPG.setProperty("rootLayoutType", "absolute");
propertiesPG.setProperty("includedLayouts", "auto");
propertiesPG.setProperty("nestedChildren", "1");
propertiesPG.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourcePG", "71_INSTANCE_U1NyroFwJGZ4");

portletResourcePG = (String)actionRequest.getAttribute("portletResourcePG");

PortletPreferences portletPreferencesPG =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourcePG);

for (Map.Entry<String, String> entry : propertiesPG.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesPG.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutPG.getPlid(), "71_INSTANCE_U1NyroFwJGZ4",
	portletPreferencesPG);

// Quick note page

Layout layoutQN = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/quick-note");

UnicodeProperties typeSettingsPropertiesQN =
	layoutQN.getTypeSettingsProperties();

typeSettingsPropertiesQN.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesQN.setProperty("column-2", "97_INSTANCE_a1SJg50KuLFc");
typeSettingsPropertiesQN.setProperty("column-1", "71_INSTANCE_FPD3mqOPjU8G,");

layoutQN.setTypeSettingsProperties(typeSettingsPropertiesQN);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutQN.getLayoutId(),
	layoutQN.getTypeSettings());

UnicodeProperties propertiesQN = new UnicodeProperties();

propertiesQN.setProperty("displayStyle", "from-level-0");
propertiesQN.setProperty("headerType", "root-layout");
propertiesQN.setProperty("bulletStyle", "dots");
propertiesQN.setProperty("rootLayoutType", "absolute");
propertiesQN.setProperty("includedLayouts", "auto");
propertiesQN.setProperty("nestedChildren", "1");
propertiesQN.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceQN", "71_INSTANCE_FPD3mqOPjU8G");

portletResourceQN = (String)actionRequest.getAttribute("portletResourceQN");

PortletPreferences portletPreferencesQN =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceQN);

for (Map.Entry<String, String> entry : propertiesQN.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesQN.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutQN.getPlid(), "71_INSTANCE_FPD3mqOPjU8G",
	portletPreferencesQN);

// Search page

Layout layoutSearch = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/search");

UnicodeProperties typeSettingsPropertiesSearch =
	layoutSearch.getTypeSettingsProperties();

typeSettingsPropertiesSearch.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesSearch.setProperty("column-2", "3");
typeSettingsPropertiesSearch.setProperty(
	"column-1", "71_INSTANCE_7rd4A6QxGxX8,");

layoutSearch.setTypeSettingsProperties(typeSettingsPropertiesSearch);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSearch.getLayoutId(),
	layoutSearch.getTypeSettings());

UnicodeProperties propertiesSearch = new UnicodeProperties();

propertiesSearch.setProperty("displayStyle", "from-level-0");
propertiesSearch.setProperty("headerType", "root-layout");
propertiesSearch.setProperty("bulletStyle", "dots");
propertiesSearch.setProperty("rootLayoutType", "absolute");
propertiesSearch.setProperty("includedLayouts", "auto");
propertiesSearch.setProperty("nestedChildren", "1");
propertiesSearch.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceSearch", "71_INSTANCE_7rd4A6QxGxX8");

portletResourceSearch = (String)actionRequest.getAttribute("portletResourceSearch");

PortletPreferences portletPreferencesSearch =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceSearch);

for (Map.Entry<String, String> entry : propertiesSearch.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesSearch.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutSearch.getPlid(), "71_INSTANCE_7rd4A6QxGxX8",
	portletPreferencesSearch);

// Sign in page

Layout layoutSIn = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/sign-in");

UnicodeProperties typeSettingsPropertiesSIn =
	layoutSIn.getTypeSettingsProperties();

typeSettingsPropertiesSIn.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesSIn.setProperty("column-2", "58");
typeSettingsPropertiesSIn.setProperty("column-1", "71_INSTANCE_shdK63UBb9yk,");

layoutSIn.setTypeSettingsProperties(typeSettingsPropertiesSIn);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSIn.getLayoutId(),
	layoutSIn.getTypeSettings());

UnicodeProperties propertiesSIn = new UnicodeProperties();

propertiesSIn.setProperty("displayStyle", "from-level-0");
propertiesSIn.setProperty("headerType", "root-layout");
propertiesSIn.setProperty("bulletStyle", "dots");
propertiesSIn.setProperty("rootLayoutType", "absolute");
propertiesSIn.setProperty("includedLayouts", "auto");
propertiesSIn.setProperty("nestedChildren", "1");
propertiesSIn.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceSIn", "71_INSTANCE_shdK63UBb9yk");

portletResourceSIn = (String)actionRequest.getAttribute("portletResourceSIn");

PortletPreferences portletPreferencesSIn =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceSIn);

for (Map.Entry<String, String> entry : propertiesSIn.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesSIn.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutSIn.getPlid(), "71_INSTANCE_shdK63UBb9yk",
	portletPreferencesSIn);

// Software catalog page

Layout layoutSoftwareC = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/software-catalog");

UnicodeProperties typeSettingsPropertiesSoftwareC =
	layoutSoftwareC.getTypeSettingsProperties();

typeSettingsPropertiesSoftwareC.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesSoftwareC.setProperty("column-2", "98");
typeSettingsPropertiesSoftwareC.setProperty(
	"column-1", "71_INSTANCE_X6zDk2NRQIS0,");

layoutSoftwareC.setTypeSettingsProperties(typeSettingsPropertiesSoftwareC);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSoftwareC.getLayoutId(),
	layoutSoftwareC.getTypeSettings());

UnicodeProperties propertiesSoftwareC = new UnicodeProperties();

propertiesSoftwareC.setProperty("displayStyle", "from-level-0");
propertiesSoftwareC.setProperty("headerType", "root-layout");
propertiesSoftwareC.setProperty("bulletStyle", "dots");
propertiesSoftwareC.setProperty("rootLayoutType", "absolute");
propertiesSoftwareC.setProperty("includedLayouts", "auto");
propertiesSoftwareC.setProperty("nestedChildren", "1");
propertiesSoftwareC.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceSoftwareC", "71_INSTANCE_X6zDk2NRQIS0");

portletResourceSoftwareC = (String)actionRequest.getAttribute(
	"portletResourceSoftwareC");

PortletPreferences portletPreferencesSoftwareC =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceSoftwareC);

for (Map.Entry<String, String> entry : propertiesSoftwareC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesSoftwareC.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutSoftwareC.getPlid(), "71_INSTANCE_X6zDk2NRQIS0",
	portletPreferencesSoftwareC);

// Translator page

Layout layoutTranslator = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/translator");

UnicodeProperties typeSettingsPropertiesTranslator =
	layoutTranslator.getTypeSettingsProperties();

typeSettingsPropertiesTranslator.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesTranslator.setProperty("column-2", "26");
typeSettingsPropertiesTranslator.setProperty(
	"column-1", "71_INSTANCE_3mDQzC5CSJCA,");

layoutTranslator.setTypeSettingsProperties(typeSettingsPropertiesTranslator);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutTranslator.getLayoutId(),
	layoutTranslator.getTypeSettings());

UnicodeProperties propertiesTranslator = new UnicodeProperties();

propertiesTranslator.setProperty("displayStyle", "from-level-0");
propertiesTranslator.setProperty("headerType", "root-layout");
propertiesTranslator.setProperty("bulletStyle", "dots");
propertiesTranslator.setProperty("rootLayoutType", "absolute");
propertiesTranslator.setProperty("includedLayouts", "auto");
propertiesTranslator.setProperty("nestedChildren", "1");
propertiesTranslator.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceTranslator","71_INSTANCE_3mDQzC5CSJCA");
portletResourceTranslator = (String)actionRequest.getAttribute(
	"portletResourceTranslator");

PortletPreferences portletPreferencesTranslator =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceTranslator);

for (Map.Entry<String, String> entry : propertiesTranslator.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesTranslator.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutTranslator.getPlid(), "71_INSTANCE_3mDQzC5CSJCA",
	portletPreferencesTranslator);

// Unit converter page

Layout layoutUC = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/unit-converter");

UnicodeProperties typeSettingsPropertiesUC =
	layoutUC.getTypeSettingsProperties();

typeSettingsPropertiesUC.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesUC.setProperty("column-2", "27");
typeSettingsPropertiesUC.setProperty("column-1", "71_INSTANCE_vMl8RSCKxaP8,");

layoutUC.setTypeSettingsProperties(typeSettingsPropertiesUC);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutUC.getLayoutId(),
	layoutUC.getTypeSettings());

UnicodeProperties propertiesUC = new UnicodeProperties();

propertiesUC.setProperty("displayStyle", "from-level-0");
propertiesUC.setProperty("headerType", "root-layout");
propertiesUC.setProperty("bulletStyle", "dots");
propertiesUC.setProperty("rootLayoutType", "absolute");
propertiesUC.setProperty("includedLayouts", "auto");
propertiesUC.setProperty("nestedChildren", "1");
propertiesUC.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceUC", "71_INSTANCE_vMl8RSCKxaP8");

portletResourceUC = (String)actionRequest.getAttribute("portletResourceUC");

PortletPreferences portletPreferencesUC =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceUC);

for (Map.Entry<String, String> entry : propertiesUC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesUC.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutUC.getPlid(), "71_INSTANCE_vMl8RSCKxaP8",
	portletPreferencesUC);
