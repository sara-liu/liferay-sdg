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

// Add content management part

Map<Locale, String> nameMapContentMan = new HashMap<Locale, String>();

nameMapContentMan.put(Locale.US, "Content Management");

Map<Locale, String> titleMapContentMan = new HashMap<Locale, String>();

titleMapContentMan.put(Locale.US, "");

Map<Locale, String> descriptionMapContentMan = new HashMap<Locale, String>();

descriptionMapContentMan.put(Locale.US, "");

Map<Locale, String> keywordsMapContentMan = new HashMap<Locale, String>();

keywordsMapContentMan.put(Locale.US, "");

Map<Locale, String> robotsMapContentMan = new HashMap<Locale, String>();

robotsMapContentMan.put(Locale.US, "");

Map<Locale, String> friendlyURLMapContentMan = new HashMap<Locale, String>();

friendlyURLMapContentMan.put(Locale.US, "/content-management");

Layout layoutContentMan = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapContentMan, titleMapContentMan,
	descriptionMapContentMan, keywordsMapContentMan, robotsMapContentMan,
	"link_to_layout", null, false, friendlyURLMapContentMan,
	serviceContext);

layoutContentManId = layoutContentMan.getLayoutId();

Map<Locale, String> nameMapAS = new HashMap<Locale, String>();

nameMapAS.put(Locale.US, "Asset Publisher");

Map<Locale, String> titleMapAS = new HashMap<Locale, String>();

titleMapAS.put(Locale.US, "");

Map<Locale, String> descriptionMapAS = new HashMap<Locale, String>();

descriptionMapAS.put(Locale.US, "");

Map<Locale, String> keywordsMapAS = new HashMap<Locale, String>();

keywordsMapAS.put(Locale.US, "");

Map<Locale, String> robotsMapAS = new HashMap<Locale, String>();

robotsMapAS.put(Locale.US, "");

Map<Locale, String> friendlyURLMapAS = new HashMap<Locale, String>();

friendlyURLMapAS.put(Locale.US, "/asset-publisher");

Layout layoutAS = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapAS, titleMapAS,
	descriptionMapAS, keywordsMapAS, robotsMapAS, "portlet", null, false,
	friendlyURLMapAS, serviceContext);

Map<Locale, String> nameMapBreadcrumb = new HashMap<Locale, String>();

nameMapBreadcrumb.put(Locale.US, "Breadcrumb");

Map<Locale, String> titleMapBreadcrumb = new HashMap<Locale, String>();

titleMapBreadcrumb.put(Locale.US, "");

Map<Locale, String> descriptionMapBreadcrumb = new HashMap<Locale, String>();

descriptionMapBreadcrumb.put(Locale.US, "");

Map<Locale, String> keywordsMapBreadcrumb = new HashMap<Locale, String>();

keywordsMapBreadcrumb.put(Locale.US, "");

Map<Locale, String> robotsMapBreadcrumb = new HashMap<Locale, String>();

robotsMapBreadcrumb.put(Locale.US, "");

Map<Locale, String> friendlyURLMapBreadcrumb = new HashMap<Locale, String>();

friendlyURLMapBreadcrumb.put(Locale.US, "/breadcrumb");

Layout layoutBreadcrumb = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapBreadcrumb,
	titleMapBreadcrumb, descriptionMapBreadcrumb, keywordsMapBreadcrumb,
	robotsMapBreadcrumb, "portlet", null, false, friendlyURLMapBreadcrumb,
	serviceContext);

Map<Locale, String> nameMapCN = new HashMap<Locale, String>();

nameMapCN.put(Locale.US, "Category Navigation");

Map<Locale, String> titleMapCN = new HashMap<Locale, String>();

titleMapCN.put(Locale.US, "");

Map<Locale, String> descriptionMapCN = new HashMap<Locale, String>();

descriptionMapCN.put(Locale.US, "");

Map<Locale, String> keywordsMapCN = new HashMap<Locale, String>();

keywordsMapCN.put(Locale.US, "");

Map<Locale, String> robotsMapCN = new HashMap<Locale, String>();

robotsMapCN.put(Locale.US, "");

Map<Locale, String> friendlyURLMapCN = new HashMap<Locale, String>();

friendlyURLMapCN.put(Locale.US, "/category-navigation");

Layout layoutCN = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapCN, titleMapCN,
	descriptionMapCN, keywordsMapCN, robotsMapCN, "portlet", null, false,
	friendlyURLMapCN, serviceContext);

Map<Locale, String> nameMapDAM = new HashMap<Locale, String>();

nameMapDAM.put(Locale.US, "Documents and Media");

Map<Locale, String> titleMapDAM = new HashMap<Locale, String>();

titleMapDAM.put(Locale.US, "");

Map<Locale, String> descriptionMapDAM = new HashMap<Locale, String>();

descriptionMapDAM.put(Locale.US, "");

Map<Locale, String> keywordsMapDAM = new HashMap<Locale, String>();

keywordsMapDAM.put(Locale.US, "");

Map<Locale, String> robotsMapDAM = new HashMap<Locale, String>();

robotsMapDAM.put(Locale.US, "");

Map<Locale, String> friendlyURLMapDAM = new HashMap<Locale, String>();

friendlyURLMapDAM.put(Locale.US, "/documents-and-media");

Layout layoutDAM = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapDAM, titleMapDAM,
	descriptionMapDAM, keywordsMapDAM, robotsMapDAM, "portlet", null,
	false, friendlyURLMapDAM, serviceContext);

Map<Locale, String> nameMapNPortlet = new HashMap<Locale, String>();

nameMapNPortlet.put(Locale.US, "Nested Portlets");

Map<Locale, String> titleMapNPortlet = new HashMap<Locale, String>();

titleMapNPortlet.put(Locale.US, "");

Map<Locale, String> descriptionMapNPortlet = new HashMap<Locale, String>();

descriptionMapNPortlet.put(Locale.US, "");

Map<Locale, String> keywordsMapNPortlet = new HashMap<Locale, String>();

keywordsMapNPortlet.put(Locale.US, "");

Map<Locale, String> robotsMapNPortlet = new HashMap<Locale, String>();

robotsMapNPortlet.put(Locale.US, "");

Map<Locale, String> friendlyURLMapNPortlet = new HashMap<Locale, String>();

friendlyURLMapNPortlet.put(Locale.US, "/nested-portlets");

Layout layoutNPortlet = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapNPortlet,
	titleMapNPortlet, descriptionMapNPortlet, keywordsMapNPortlet,
	robotsMapNPortlet, "portlet", null, false, friendlyURLMapNPortlet,
	serviceContext);

Map<Locale, String> nameMapPD = new HashMap<Locale, String>();

nameMapPD.put(Locale.US, "Polls Display");

Map<Locale, String> titleMapPD = new HashMap<Locale, String>();

titleMapPD.put(Locale.US, "");

Map<Locale, String> descriptionMapPD = new HashMap<Locale, String>();

descriptionMapPD.put(Locale.US, "");

Map<Locale, String> keywordsMapPD = new HashMap<Locale, String>();

keywordsMapPD.put(Locale.US, "");

Map<Locale, String> robotsMapPD = new HashMap<Locale, String>();

robotsMapPD.put(Locale.US, "");

Map<Locale, String> friendlyURLMapPD = new HashMap<Locale, String>();

friendlyURLMapPD.put(Locale.US, "/polls-display");

Layout layoutPD = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapPD, titleMapPD,
	descriptionMapPD, keywordsMapPD, robotsMapPD, "portlet", null, false,
	friendlyURLMapPD, serviceContext);

Map<Locale, String> nameMapRD = new HashMap<Locale, String>();

nameMapRD.put(Locale.US, "Recent Downloads");

Map<Locale, String> titleMapRD = new HashMap<Locale, String>();

titleMapRD.put(Locale.US, "");

Map<Locale, String> descriptionMapRD = new HashMap<Locale, String>();

descriptionMapRD.put(Locale.US, "");

Map<Locale, String> keywordsMapRD = new HashMap<Locale, String>();

keywordsMapRD.put(Locale.US, "");

Map<Locale, String> robotsMapRD = new HashMap<Locale, String>();

robotsMapRD.put(Locale.US, "");

Map<Locale, String> friendlyURLMapRD = new HashMap<Locale, String>();

friendlyURLMapRD.put(Locale.US, "/recent-downloads");

Layout layoutRD = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapRD, titleMapRD,
	descriptionMapRD, keywordsMapRD, robotsMapRD, "portlet", null, false,
	friendlyURLMapRD, serviceContext);

Map<Locale, String> nameMapRA = new HashMap<Locale, String>();

nameMapRA.put(Locale.US, "Related Assets");

Map<Locale, String> titleMapRA = new HashMap<Locale, String>();

titleMapRA.put(Locale.US, "");

Map<Locale, String> descriptionMapRA = new HashMap<Locale, String>();

descriptionMapRA.put(Locale.US, "");

Map<Locale, String> keywordsMapRA = new HashMap<Locale, String>();

keywordsMapRA.put(Locale.US, "");

Map<Locale, String> robotsMapRA = new HashMap<Locale, String>();

robotsMapRA.put(Locale.US, "");

Map<Locale, String> friendlyURLMapRA = new HashMap<Locale, String>();

friendlyURLMapRA.put(Locale.US, "/related-assets");

Layout layoutRA = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapRA, titleMapRA,
	descriptionMapRA, keywordsMapRA, robotsMapRA, "portlet", null, false,
	friendlyURLMapRA, serviceContext);

Map<Locale, String> nameMapSiteM = new HashMap<Locale, String>();

nameMapSiteM.put(Locale.US, "Site Map");

Map<Locale, String> titleMapSiteM = new HashMap<Locale, String>();

titleMapSiteM.put(Locale.US, "");

Map<Locale, String> descriptionMapSiteM = new HashMap<Locale, String>();

descriptionMapSiteM.put(Locale.US, "");

Map<Locale, String> keywordsMapSiteM = new HashMap<Locale, String>();

keywordsMapSiteM.put(Locale.US, "");

Map<Locale, String> robotsMapSiteM = new HashMap<Locale, String>();

robotsMapSiteM.put(Locale.US, "");

Map<Locale, String> friendlyURLMapSiteM = new HashMap<Locale, String>();

friendlyURLMapSiteM.put(Locale.US, "/site-map");

Layout layoutSiteM = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapSiteM, titleMapSiteM,
	descriptionMapSiteM, keywordsMapSiteM, robotsMapSiteM, "portlet", null,
	false, friendlyURLMapSiteM, serviceContext);

Map<Locale, String> nameMapTagC = new HashMap<Locale, String>();

nameMapTagC.put(Locale.US, "Tag Cloud");

Map<Locale, String> titleMapTagC = new HashMap<Locale, String>();

titleMapTagC.put(Locale.US, "");

Map<Locale, String> descriptionMapTagC = new HashMap<Locale, String>();

descriptionMapTagC.put(Locale.US, "");

Map<Locale, String> keywordsMapTagC = new HashMap<Locale, String>();

keywordsMapTagC.put(Locale.US, "");

Map<Locale, String> robotsMapTagC = new HashMap<Locale, String>();

robotsMapTagC.put(Locale.US, "");

Map<Locale, String> friendlyURLMapTagC = new HashMap<Locale, String>();

friendlyURLMapTagC.put(Locale.US, "/tag-cloud");

Layout layoutTagC = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapTagC, titleMapTagC,
	descriptionMapTagC, keywordsMapTagC, robotsMapTagC, "portlet", null,
	false, friendlyURLMapTagC, serviceContext);

Map<Locale, String> nameMapWC = new HashMap<Locale, String>();

nameMapWC.put(Locale.US, "Web Content");

Map<Locale, String> titleMapWC = new HashMap<Locale, String>();

titleMapWC.put(Locale.US, "");

Map<Locale, String> descriptionMapWC = new HashMap<Locale, String>();

descriptionMapWC.put(Locale.US, "");

Map<Locale, String> keywordsMapWC = new HashMap<Locale, String>();

keywordsMapWC.put(Locale.US, "");

Map<Locale, String> robotsMapWC = new HashMap<Locale, String>();

robotsMapWC.put(Locale.US, "");

Map<Locale, String> friendlyURLMapWC = new HashMap<Locale, String>();

friendlyURLMapWC.put(Locale.US, "/web-content");

Layout layoutWC = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapWC, titleMapWC,
	descriptionMapWC, keywordsMapWC, robotsMapWC, "portlet", null, false,
	friendlyURLMapWC, serviceContext);

Map<Locale, String> nameMapXC = new HashMap<Locale, String>();

nameMapXC.put(Locale.US, "XSL Content");

Map<Locale, String> titleMapXC = new HashMap<Locale, String>();

titleMapXC.put(Locale.US, "");

Map<Locale, String> descriptionMapXC = new HashMap<Locale, String>();

descriptionMapXC.put(Locale.US, "");

Map<Locale, String> keywordsMapXC = new HashMap<Locale, String>();

keywordsMapXC.put(Locale.US, "");

Map<Locale, String> robotsMapXC = new HashMap<Locale, String>();

robotsMapXC.put(Locale.US, "");

Map<Locale, String> friendlyURLMapXC = new HashMap<Locale, String>();

friendlyURLMapXC.put(Locale.US, "/xsl-content");

Layout layoutXC = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapXC, titleMapXC,
	descriptionMapXC, keywordsMapXC, robotsMapXC, "portlet", null, false,
	friendlyURLMapXC, serviceContext);

// Content management page link to asset publish page.

UnicodeProperties typeSettingsPropertiesContentMan =
	layoutContentMan.getTypeSettingsProperties();

typeSettingsPropertiesContentMan.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesContentMan.setProperty("show-alternate-links", "true");
typeSettingsPropertiesContentMan.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesContentMan.setProperty(
	"linkToLayoutId", String.valueOf(layoutAS.getLayoutId()));
typeSettingsPropertiesContentMan.setProperty("sitemap-include", "1");
typeSettingsPropertiesContentMan.setProperty("layout-template-id", "2_columns_ii");

layoutContentMan.setTypeSettingsProperties(typeSettingsPropertiesContentMan);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutContentManId,
	layoutContentMan.getTypeSettings());
