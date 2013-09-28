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

// Asset publisher page

Layout layoutAS = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/asset-publisher");

UnicodeProperties typeSettingsPropertiesAS =
	layoutAS.getTypeSettingsProperties();

typeSettingsPropertiesAS.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesAS.setProperty("column-2", "101_INSTANCE_cHzGSpUq98kH");
typeSettingsPropertiesAS.setProperty("column-1", "71_INSTANCE_kUWGUtU6zEnt,");

layoutAS.setTypeSettingsProperties(typeSettingsPropertiesAS);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutAS.getLayoutId(),
	layoutAS.getTypeSettings());

UnicodeProperties propertiesAS = new UnicodeProperties();

propertiesAS.setProperty("displayStyle", "from-level-0");
propertiesAS.setProperty("headerType", "root-layout");
propertiesAS.setProperty("bulletStyle", "dots");
propertiesAS.setProperty("rootLayoutType", "absolute");
propertiesAS.setProperty("includedLayouts", "auto");
propertiesAS.setProperty("nestedChildren", "1");
propertiesAS.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceAS", "71_INSTANCE_kUWGUtU6zEnt");

portletResourceAS = (String)actionRequest.getAttribute("portletResourceAS");

PortletPreferences portletPreferencesAS =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceAS);

for (Map.Entry<String, String> entry : propertiesAS.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesAS.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutAS.getPlid(), "71_INSTANCE_kUWGUtU6zEnt",
	portletPreferencesAS);

// Breadcrumb page

Layout layoutBreadcrumb = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/breadcrumb");

UnicodeProperties typeSettingsPropertiesBreadcrumb =
	layoutBreadcrumb.getTypeSettingsProperties();

typeSettingsPropertiesBreadcrumb.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesBreadcrumb.setProperty(
	"column-2", "73_INSTANCE_bOhQtaG2uIry");
typeSettingsPropertiesBreadcrumb.setProperty(
	"column-1", "71_INSTANCE_6Oy6CHmEnaPW,");

layoutBreadcrumb.setTypeSettingsProperties(typeSettingsPropertiesBreadcrumb);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutBreadcrumb.getLayoutId(),
	layoutBreadcrumb.getTypeSettings());

UnicodeProperties propertiesBreadcrumb = new UnicodeProperties();

propertiesBreadcrumb.setProperty("displayStyle", "from-level-0");
propertiesBreadcrumb.setProperty("headerType", "root-layout");
propertiesBreadcrumb.setProperty("bulletStyle", "dots");
propertiesBreadcrumb.setProperty("rootLayoutType", "absolute");
propertiesBreadcrumb.setProperty("includedLayouts", "auto");
propertiesBreadcrumb.setProperty("nestedChildren", "1");
propertiesBreadcrumb.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceBreadcrumb", "71_INSTANCE_6Oy6CHmEnaPW");

portletResourceBreadcrumb = (String)actionRequest.getAttribute(
	"portletResourceBreadcrumb");

PortletPreferences portletPreferencesBreadcrumb =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceBreadcrumb);

for (Map.Entry<String, String> entry : propertiesBreadcrumb.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesBreadcrumb.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutBreadcrumb.getPlid(), "71_INSTANCE_6Oy6CHmEnaPW",
	portletPreferencesBreadcrumb);

// Category navigation page

Layout layoutCN = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/category-navigation");

UnicodeProperties typeSettingsPropertiesCN =
	layoutCN.getTypeSettingsProperties();

typeSettingsPropertiesCN.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesCN.setProperty("column-2", "122_INSTANCE_wK4hm8kPKiq2");
typeSettingsPropertiesCN.setProperty("column-1", "71_INSTANCE_eyemFjZqJ1Kk,");

layoutCN.setTypeSettingsProperties(typeSettingsPropertiesCN);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutCN.getLayoutId(),
	layoutCN.getTypeSettings());

UnicodeProperties propertiesCN = new UnicodeProperties();

propertiesCN.setProperty("displayStyle", "from-level-0");
propertiesCN.setProperty("headerType", "root-layout");
propertiesCN.setProperty("bulletStyle", "dots");
propertiesCN.setProperty("rootLayoutType", "absolute");
propertiesCN.setProperty("includedLayouts", "auto");
propertiesCN.setProperty("nestedChildren", "1");
propertiesCN.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceCN", "71_INSTANCE_eyemFjZqJ1Kk");

portletResourceCN = (String)actionRequest.getAttribute("portletResourceCN");

PortletPreferences portletPreferencesCN =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceCN);

for (Map.Entry<String, String> entry : propertiesCN.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesCN.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutCN.getPlid(), "71_INSTANCE_eyemFjZqJ1Kk",
	portletPreferencesCN);

// Documents and media

Layout layoutDAM = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/documents-and-media");

UnicodeProperties typeSettingsPropertiesDAM =
	layoutDAM.getTypeSettingsProperties();

typeSettingsPropertiesDAM.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesDAM.setProperty("column-2", "20");
typeSettingsPropertiesDAM.setProperty("column-1", "71_INSTANCE_rXmUME1go3zw");

layoutDAM.setTypeSettingsProperties(typeSettingsPropertiesDAM);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutDAM.getLayoutId(),
	layoutDAM.getTypeSettings());

UnicodeProperties propertiesDAM = new UnicodeProperties();

propertiesDAM.setProperty("displayStyle", "from-level-0");
propertiesDAM.setProperty("headerType", "root-layout");
propertiesDAM.setProperty("bulletStyle", "dots");
propertiesDAM.setProperty("rootLayoutType", "absolute");
propertiesDAM.setProperty("includedLayouts", "auto");
propertiesDAM.setProperty("nestedChildren", "1");
propertiesDAM.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceDAM", "71_INSTANCE_rXmUME1go3zw");

portletResourceDAM = (String)actionRequest.getAttribute("portletResourceDAM");

PortletPreferences portletPreferencesDAM =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceDAM);

for (Map.Entry<String, String> entry : propertiesDAM.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesDAM.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutDAM.getPlid(), "71_INSTANCE_rXmUME1go3zw",
	portletPreferencesDAM);

// Nested portlets page

Layout layoutNPortlet = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/nested-portlets");

UnicodeProperties typeSettingsPropertiesNPortlet =
	layoutNPortlet.getTypeSettingsProperties();

typeSettingsPropertiesNPortlet.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesNPortlet.setProperty(
	"_118_INSTANCE_mQnir2HWDHrM__column-3", "115");
typeSettingsPropertiesNPortlet.setProperty(
	"_118_INSTANCE_mQnir2HWDHrM__column-2", "71_INSTANCE_u9La1oksuZYZ,");
typeSettingsPropertiesNPortlet.setProperty(
	"_118_INSTANCE_mQnir2HWDHrM__column-1", "73_INSTANCE_TtL6I5irPv5t,");
typeSettingsPropertiesNPortlet.setProperty(
	"nested-column-ids",
	"118_INSTANCE_mQnir2HWDHrM__column-1, _118_INSTANCE_mQnir2HWDHrM__column-2,_118_INSTANCE_mQnir2HWDHrM__column-3,");
typeSettingsPropertiesNPortlet.setProperty("column-2", "118_INSTANCE_mQnir2HWDHrM,");
typeSettingsPropertiesNPortlet.setProperty("column-1", "71_INSTANCE_rXmUME1go3zm,");

layoutNPortlet.setTypeSettingsProperties(typeSettingsPropertiesNPortlet);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutNPortlet.getLayoutId(),
	layoutNPortlet.getTypeSettings());

UnicodeProperties propertiesNPortlet = new UnicodeProperties();

propertiesNPortlet.setProperty("displayStyle", "from-level-0");
propertiesNPortlet.setProperty("headerType", "root-layout");
propertiesNPortlet.setProperty("bulletStyle", "dots");
propertiesNPortlet.setProperty("rootLayoutType", "absolute");
propertiesNPortlet.setProperty("includedLayouts", "auto");
propertiesNPortlet.setProperty("nestedChildren", "1");
propertiesNPortlet.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceNPortlet", "71_INSTANCE_rXmUME1go3zm");

portletResourceNPortlet = (String)actionRequest.getAttribute("portletResourceNPortlet");

PortletPreferences portletPreferencesNPortlet =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceNPortlet);

for (Map.Entry<String, String> entry : propertiesNPortlet.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesNPortlet.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutNPortlet.getPlid(), "71_INSTANCE_rXmUME1go3zm",
	portletPreferencesNPortlet);

// Polls display page

Layout layoutPD = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/polls-display");

UnicodeProperties typeSettingsPropertiesPD =
	layoutPD.getTypeSettingsProperties();

typeSettingsPropertiesPD.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesPD.setProperty("column-2", "59_INSTANCE_TbzT9KKPaRFZ");
typeSettingsPropertiesPD.setProperty("column-1", "71_INSTANCE_FkVY7cJ3m6cm,");

layoutPD.setTypeSettingsProperties(typeSettingsPropertiesPD);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutPD.getLayoutId(),
	layoutPD.getTypeSettings());

UnicodeProperties propertiesPD = new UnicodeProperties();

propertiesPD.setProperty("displayStyle", "from-level-0");
propertiesPD.setProperty("headerType", "root-layout");
propertiesPD.setProperty("bulletStyle", "dots");
propertiesPD.setProperty("rootLayoutType", "absolute");
propertiesPD.setProperty("includedLayouts", "auto");
propertiesPD.setProperty("nestedChildren", "1");
propertiesPD.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourcePD", "71_INSTANCE_FkVY7cJ3m6cm");

portletResourcePD = (String)actionRequest.getAttribute("portletResourcePD");

PortletPreferences portletPreferencesPD =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourcePD);

for (Map.Entry<String, String> entry : propertiesPD.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesPD.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutPD.getPlid(), "71_INSTANCE_FkVY7cJ3m6cm",
	portletPreferencesPD);

// Recent downloads page

Layout layoutRD = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/recent-downloads");

UnicodeProperties typeSettingsPropertiesRD =
	layoutRD.getTypeSettingsProperties();

typeSettingsPropertiesRD.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesRD.setProperty("column-2", "64");
typeSettingsPropertiesRD.setProperty("column-1", "71_INSTANCE_yDtUc5UAAhWm,");

layoutRD.setTypeSettingsProperties(typeSettingsPropertiesRD);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutRD.getLayoutId(),
	layoutRD.getTypeSettings());

UnicodeProperties propertiesRD = new UnicodeProperties();

propertiesRD.setProperty("displayStyle", "from-level-0");
propertiesRD.setProperty("headerType", "root-layout");
propertiesRD.setProperty("bulletStyle", "dots");
propertiesRD.setProperty("rootLayoutType", "absolute");
propertiesRD.setProperty("includedLayouts", "auto");
propertiesRD.setProperty("nestedChildren", "1");
propertiesRD.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceRD", "71_INSTANCE_yDtUc5UAAhWm");

portletResourceRD = (String)actionRequest.getAttribute("portletResourceRD");

PortletPreferences portletPreferencesRD =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceRD);

for (Map.Entry<String, String> entry : propertiesRD.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesRD.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutRD.getPlid(), "71_INSTANCE_yDtUc5UAAhWm",
	portletPreferencesRD);

// Related assets page

Layout layoutRA = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/related-assets");

UnicodeProperties typeSettingsPropertiesRA =
	layoutRA.getTypeSettingsProperties();

typeSettingsPropertiesRA.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesRA.setProperty(
	"column-2", "175_INSTANCE_s90usYdR23Ii,");
typeSettingsPropertiesRA.setProperty("column-1", "71_INSTANCE_yDtUc5UAAhW4,");

layoutRA.setTypeSettingsProperties(typeSettingsPropertiesRA);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutRA.getLayoutId(),
	layoutRA.getTypeSettings());

UnicodeProperties propertiesRA = new UnicodeProperties();

propertiesRA.setProperty("displayStyle", "from-level-0");
propertiesRA.setProperty("headerType", "root-layout");
propertiesRA.setProperty("bulletStyle", "dots");
propertiesRA.setProperty("rootLayoutType", "absolute");
propertiesRA.setProperty("includedLayouts", "auto");
propertiesRA.setProperty("nestedChildren", "1");
propertiesRA.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceRA", "71_INSTANCE_yDtUc5UAAhW4");

portletResourceRA = (String)actionRequest.getAttribute("portletResourceRA");

PortletPreferences portletPreferencesRA =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceRA);

for (Map.Entry<String, String> entry : propertiesRA.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesRA.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutRA.getPlid(), "71_INSTANCE_yDtUc5UAAhW4",
	portletPreferencesRA);

// Site map page

Layout layoutSiteM = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/site-map");

UnicodeProperties typeSettingsPropertiesSiteM =
	layoutSiteM.getTypeSettingsProperties();

typeSettingsPropertiesSiteM.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesSiteM.setProperty("column-2", "85_INSTANCE_8ynIjUSaM1Xf");
typeSettingsPropertiesSiteM.setProperty("column-1", "71_INSTANCE_YnegvD2AETDa,");

layoutSiteM.setTypeSettingsProperties(typeSettingsPropertiesSiteM);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSiteM.getLayoutId(),
	layoutSiteM.getTypeSettings());

UnicodeProperties propertiesSiteM = new UnicodeProperties();

propertiesSiteM.setProperty("displayStyle", "from-level-0");
propertiesSiteM.setProperty("headerType", "root-layout");
propertiesSiteM.setProperty("bulletStyle", "dots");
propertiesSiteM.setProperty("rootLayoutType", "absolute");
propertiesSiteM.setProperty("includedLayouts", "auto");
propertiesSiteM.setProperty("nestedChildren", "1");
propertiesSiteM.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceSiteM", "71_INSTANCE_YnegvD2AETDa");

portletResourceSiteM = (String)actionRequest.getAttribute(
	"portletResourceSiteM");

PortletPreferences portletPreferencesSiteM =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceSiteM);

for (Map.Entry<String, String> entry : propertiesSiteM.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesSiteM.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutSiteM.getPlid(), "71_INSTANCE_YnegvD2AETDa",
	portletPreferencesSiteM);

// Tag cloud page

Layout layoutTagC = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/tag-cloud");

UnicodeProperties typeSettingsPropertiesTagC =
	layoutTagC.getTypeSettingsProperties();

typeSettingsPropertiesTagC.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesTagC.setProperty(
	"column-2", "141_INSTANCE_W3mu4VyEzpgz,148_INSTANCE_ovvJg184K1ix");
typeSettingsPropertiesTagC.setProperty("column-1", "71_INSTANCE_LWB5t48iFqIP,");

layoutTagC.setTypeSettingsProperties(typeSettingsPropertiesTagC);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutTagC.getLayoutId(),
	layoutTagC.getTypeSettings());

UnicodeProperties propertiesTagC = new UnicodeProperties();

propertiesTagC.setProperty("displayStyle", "from-level-0");
propertiesTagC.setProperty("headerType", "root-layout");
propertiesTagC.setProperty("bulletStyle", "dots");
propertiesTagC.setProperty("rootLayoutType", "absolute");
propertiesTagC.setProperty("includedLayouts", "auto");
propertiesTagC.setProperty("nestedChildren", "1");
propertiesTagC.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceTagC", "71_INSTANCE_LWB5t48iFqIP");

portletResourceTagC = (String)actionRequest.getAttribute(
	"portletResourceTagC");

PortletPreferences portletPreferencesTagC =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceTagC);

for (Map.Entry<String, String> entry : propertiesTagC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesTagC.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutTagC.getPlid(), "71_INSTANCE_LWB5t48iFqIP",
	portletPreferencesTagC);

// Web content page

Layout layoutWC = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/web-content");

UnicodeProperties typeSettingsPropertiesWCPage =
	layoutWC.getTypeSettingsProperties();

typeSettingsPropertiesWCPage.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesWCPage.setProperty(
	"column-2", "77,56_INSTANCE_COxqya3VTLhr");
typeSettingsPropertiesWCPage.setProperty(
	"column-1", "71_INSTANCE_kcplKlFfMkj3,");

layoutWC.setTypeSettingsProperties(typeSettingsPropertiesWCPage);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutWC.getLayoutId(),
	layoutWC.getTypeSettings());

UnicodeProperties propertiesWC = new UnicodeProperties();

propertiesWC.setProperty("displayStyle", "from-level-0");
propertiesWC.setProperty("headerType", "root-layout");
propertiesWC.setProperty("bulletStyle", "dots");
propertiesWC.setProperty("rootLayoutType", "absolute");
propertiesWC.setProperty("includedLayouts", "auto");
propertiesWC.setProperty("nestedChildren", "1");
propertiesWC.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceWC", "71_INSTANCE_kcplKlFfMkj3");

portletResourceWC = (String)actionRequest.getAttribute("portletResourceWC");

PortletPreferences portletPreferencesWCPage =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceWC);

for (Map.Entry<String, String> entry : propertiesWC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesWCPage.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutWC.getPlid(), "71_INSTANCE_kcplKlFfMkj3",
	portletPreferencesWCPage);

// Xsl content page

Layout layoutXC = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/xsl-content");

UnicodeProperties typeSettingsPropertiesXC =
	layoutXC.getTypeSettingsProperties();

typeSettingsPropertiesXC.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesXC.setProperty("column-2", "102_INSTANCE_4WS583Eepz19");
typeSettingsPropertiesXC.setProperty("column-1", "71_INSTANCE_9sS3bcUNQ2ox,");

layoutXC.setTypeSettingsProperties(typeSettingsPropertiesXC);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutXC.getLayoutId(),
	layoutXC.getTypeSettings());

UnicodeProperties propertiesXC = new UnicodeProperties();

propertiesXC.setProperty("displayStyle", "from-level-0");
propertiesXC.setProperty("headerType", "root-layout");
propertiesXC.setProperty("bulletStyle", "dots");
propertiesXC.setProperty("rootLayoutType", "absolute");
propertiesXC.setProperty("includedLayouts", "auto");
propertiesXC.setProperty("nestedChildren", "1");
propertiesXC.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceXC", "71_INSTANCE_9sS3bcUNQ2ox");

portletResourceXC = (String)actionRequest.getAttribute("portletResourceXC");

PortletPreferences portletPreferencesXC =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceXC);

for (Map.Entry<String, String> entry : propertiesXC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesXC.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutXC.getPlid(), "71_INSTANCE_9sS3bcUNQ2ox",
	portletPreferencesXC);
