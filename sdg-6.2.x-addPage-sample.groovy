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

// Add sample part

Map<Locale, String> nameMapSample = new HashMap<Locale, String>();

nameMapSample.put(Locale.US, "Sample");

Map<Locale, String> titleMapSample = new HashMap<Locale, String>();

titleMapSample.put(Locale.US, "");

Map<Locale, String> descriptionMapSample = new HashMap<Locale, String>();

descriptionMapSample.put(Locale.US, "");

Map<Locale, String> keywordsMapSample = new HashMap<Locale, String>();

keywordsMapSample.put(Locale.US, "");

Map<Locale, String> robotsMapSample = new HashMap<Locale, String>();

robotsMapSample.put(Locale.US, "");

Map<Locale, String> friendlyURLMapSample = new HashMap<Locale, String>();

friendlyURLMapSample.put(Locale.US, "/sample");

Layout layoutSample = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapSample, titleMapSample,
	descriptionMapSample, keywordsMapSample, robotsMapSample,
	"link_to_layout", null, false, friendlyURLMapSample, serviceContext);

layoutSampleId = layoutSample.getLayoutId();

Map<Locale, String> nameMapHV = new HashMap<Locale, String>();

nameMapHV.put(Locale.US, "Hello Velocity");

Map<Locale, String> titleMapHV = new HashMap<Locale, String>();

titleMapHV.put(Locale.US, "");

Map<Locale, String> descriptionMapHV = new HashMap<Locale, String>();

descriptionMapHV.put(Locale.US, "");

Map<Locale, String> keywordsMapHV = new HashMap<Locale, String>();

keywordsMapHV.put(Locale.US, "");

Map<Locale, String> robotsMapHV = new HashMap<Locale, String>();

robotsMapHV.put(Locale.US, "");

Map<Locale, String> friendlyURLMapHV = new HashMap<Locale, String>();

friendlyURLMapHV.put(Locale.US, "/hello-velocity");

Layout layoutHV = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutSampleId, nameMapHV, titleMapHV,
	descriptionMapHV, keywordsMapHV, robotsMapHV, "portlet", null, false,
	friendlyURLMapHV, serviceContext);

Map<Locale, String> nameMapHW = new HashMap<Locale, String>();

nameMapHW.put(Locale.US, "Hello World");

Map<Locale, String> titleMapHW = new HashMap<Locale, String>();

titleMapHW.put(Locale.US, "");

Map<Locale, String> descriptionMapHW = new HashMap<Locale, String>();

descriptionMapHW.put(Locale.US, "");

Map<Locale, String> keywordsMapHW = new HashMap<Locale, String>();

keywordsMapHW.put(Locale.US, "");

Map<Locale, String> robotsMapHW = new HashMap<Locale, String>();

robotsMapHW.put(Locale.US, "");

Map<Locale, String> friendlyURLMapHW = new HashMap<Locale, String>();

friendlyURLMapHW.put(Locale.US, "/hello-world");

Layout layoutHW = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutSampleId, nameMapHW, titleMapHW,
	descriptionMapHW, keywordsMapHW, robotsMapHW, "portlet", null, false,
	friendlyURLMapHW, serviceContext);

Map<Locale, String> nameMapIFrame = new HashMap<Locale, String>();

nameMapIFrame.put(Locale.US, "IFrame");

Map<Locale, String> titleMapIFrame = new HashMap<Locale, String>();

titleMapIFrame.put(Locale.US, "");

Map<Locale, String> descriptionMapIFrame = new HashMap<Locale, String>();

descriptionMapIFrame.put(Locale.US, "");

Map<Locale, String> keywordsMapIFrame = new HashMap<Locale, String>();

keywordsMapIFrame.put(Locale.US, "");

Map<Locale, String> robotsMapIFrame = new HashMap<Locale, String>();

robotsMapIFrame.put(Locale.US, "");

Map<Locale, String> friendlyURLMapIFrame = new HashMap<Locale, String>();

friendlyURLMapIFrame.put(Locale.US, "/iFrame");

Layout layoutIFrame = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutSampleId, nameMapIFrame, titleMapIFrame,
	descriptionMapIFrame, keywordsMapIFrame, robotsMapIFrame, "portlet",
	null, false, friendlyURLMapIFrame, serviceContext);

Map<Locale, String> nameMapWebP = new HashMap<Locale, String>();

nameMapWebP.put(Locale.US, "Web Proxy");

Map<Locale, String> titleMapWebP = new HashMap<Locale, String>();

titleMapWebP.put(Locale.US, "");

Map<Locale, String> descriptionMapWebP = new HashMap<Locale, String>();

descriptionMapWebP.put(Locale.US, "");

Map<Locale, String> keywordsMapWebP = new HashMap<Locale, String>();

keywordsMapWebP.put(Locale.US, "");

Map<Locale, String> robotsMapWebP = new HashMap<Locale, String>();

robotsMapWebP.put(Locale.US, "");

Map<Locale, String> friendlyURLMapWebP = new HashMap<Locale, String>();

friendlyURLMapWebP.put(Locale.US, "/web-proxy");

Layout layoutWebP = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutSampleId, nameMapWebP, titleMapWebP,
	descriptionMapWebP, keywordsMapWebP, robotsMapWebP, "portlet", null,
	false, friendlyURLMapWebP, serviceContext);

// Sample page link to hello velocity page.

UnicodeProperties typeSettingsPropertiesSample =
	layoutSample.getTypeSettingsProperties();

typeSettingsPropertiesSample.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesSample.setProperty("show-alternate-links", "true");
typeSettingsPropertiesSample.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesSample.setProperty(
	"linkToLayoutId", String.valueOf(layoutHV.getLayoutId()));
typeSettingsPropertiesSample.setProperty("sitemap-include", "1");
typeSettingsPropertiesSample.setProperty("layout-template-id", "2_columns_ii");

layoutSample.setTypeSettingsProperties(typeSettingsPropertiesSample);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSampleId, layoutSample.getTypeSettings());
