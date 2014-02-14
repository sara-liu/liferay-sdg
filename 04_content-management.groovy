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
import com.liferay.portlet.polls.model.PollsChoice;
import com.liferay.portlet.polls.model.PollsQuestion;
import com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil;
import com.liferay.portlet.polls.service.persistence.PollsChoiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

// Content Management

Layout contentManagementLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Content Management", "", "", "link_to_layout",
	false, "/content-management", serviceContext);

// Asset Publisher

Layout assetPublisherLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Asset Publisher", "", "", "portlet", false, "/asset-publisher",
	serviceContext);

LayoutTypePortlet assetPublisherLayoutTypePortlet =
	(LayoutTypePortlet)assetPublisherLayout.getLayoutType();

assetPublisherLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0001", "column-1", -1, false);
assetPublisherLayoutTypePortlet.addPortletId(
	userId, "101_INSTANCE_ContenAP0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, assetPublisherLayout.getLayoutId(),
	assetPublisherLayout.getTypeSettings());

// Breadcrumb

Layout breadcrumbLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(), "Breadcrumb",
	"", "", "portlet", false, "/breadcrumb", serviceContext);

LayoutTypePortlet breadcrumbLayoutTypePortlet =
	(LayoutTypePortlet)breadcrumbLayout.getLayoutType();

breadcrumbLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0002", "column-1", -1, false);
breadcrumbLayoutTypePortlet.addPortletId(
	userId, "73_INSTANCE_ContenBC0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, breadcrumbLayout.getLayoutId(),
	breadcrumbLayout.getTypeSettings());

// Categories Navigation

Layout categoriesNavigationLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Categories Navigation", "", "", "portlet", false, "/categories-navigation",
	serviceContext);

LayoutTypePortlet categoriesNavigationLayoutTypePortlet =
	(LayoutTypePortlet)categoriesNavigationLayout.getLayoutType();

categoriesNavigationLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0003", "column-1", -1, false);
categoriesNavigationLayoutTypePortlet.addPortletId(
	userId, "122_INSTANCE_ContenCN0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, categoriesNavigationLayout.getLayoutId(),
	categoriesNavigationLayout.getTypeSettings());

// Documents and Media

Layout dmLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Document and Media", "", "", "portlet", false, "/document-and-media",
	serviceContext);

LayoutTypePortlet dmLayoutTypePortlet =
	(LayoutTypePortlet)dmLayout.getLayoutType();

dmLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0004", "column-1", -1, false);
dmLayoutTypePortlet.addPortletId(userId, "20", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, dmLayout.getLayoutId(), dmLayout.getTypeSettings());

// Documents and Media Display

Layout dmDisplayLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Document and Media Display", "", "", "portlet", false,
	"/document-and-media-display", serviceContext);

LayoutTypePortlet dmDisplayLayoutTypePortlet =
	(LayoutTypePortlet)dmDisplayLayout.getLayoutType();

dmDisplayLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0005", "column-1", -1, false);
dmDisplayLayoutTypePortlet.addPortletId(
	userId, "110_INSTANCE_ContenDMD001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, dmDisplayLayout.getLayoutId(),
	dmDisplayLayout.getTypeSettings());

// Media Gallery

Layout mediaGalleryLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Media Gallery", "", "", "portlet", false, "/media-gallery",
	serviceContext);

LayoutTypePortlet mediaGalleryLayoutTypePortlet =
	(LayoutTypePortlet)mediaGalleryLayout.getLayoutType();

mediaGalleryLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0006", "column-1", -1, false);
mediaGalleryLayoutTypePortlet.addPortletId(
	userId, "31_INSTANCE_ContenMG0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, mediaGalleryLayout.getLayoutId(),
	mediaGalleryLayout.getTypeSettings());

// Navigation

Layout navigationLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Navigation", "", "", "portlet", false, "/navigation", serviceContext);

LayoutTypePortlet navigationLayoutTypePortlet =
	(LayoutTypePortlet)navigationLayout.getLayoutType();

navigationLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0007", "column-1", -1, false);
navigationLayoutTypePortlet.addPortletId(
	userId, "71_INSTANCE_ContenNav001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, navigationLayout.getLayoutId(),
	navigationLayout.getTypeSettings());

// Nested Portlets

Layout nestedPortletsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Nested Portlets", "", "", "portlet", false, "/nested-portlets",
	serviceContext);

LayoutTypePortlet nestedPortletsLayoutTypePortlet =
	(LayoutTypePortlet)nestedPortletsLayout.getLayoutType();

nestedPortletsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0008", "column-1", -1, false);
nestedPortletsLayoutTypePortlet.addPortletId(
	userId, "118_INSTANCE_ContenNP0001", "column-2", -1, false);
nestedPortletsLayoutTypePortlet.addPortletId(
	userId, "47", "_118_INSTANCE_ContenNP0001__column-1", -1, false);
nestedPortletsLayoutTypePortlet.addPortletId(
	userId, "50", "_118_INSTANCE_ContenNP0001__column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, nestedPortletsLayout.getLayoutId(),
	nestedPortletsLayout.getTypeSettings());

// Polls Display

Layout pollsDisplayLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Polls Display", "", "", "portlet", false, "/polls-display",
	serviceContext);

LayoutTypePortlet pollsDisplayLayoutTypePortlet =
	(LayoutTypePortlet)pollsDisplayLayout.getLayoutType();

pollsDisplayLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0009", "column-1", -1, false);
pollsDisplayLayoutTypePortlet.addPortletId(
	userId, "59_INSTANCE_ContenPD0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, pollsDisplayLayout.getLayoutId(),
	pollsDisplayLayout.getTypeSettings());

Map<Locale, String> pollsDisplayTitleMap = new HashMap<Locale, String>();

pollsDisplayTitleMap.put(Locale.US, "Polls Display Title");

Map<Locale, String> pollsDisplayDescriptionMap = new HashMap<Locale, String>();

pollsDisplayDescriptionMap.put(
	Locale.US, "No sapientem conceptam voluptatibus mel?");

List<PollsChoice> choices = new ArrayList<PollsChoice>();

Map<Locale, String> pollChoiceDescriptionMapA = new HashMap<Locale, String>();

pollChoiceDescriptionMapA.put(Locale.US, "Yes");

PollsChoice pollChoiceA = PollsChoiceUtil.create(0);

pollChoiceA.setName("a");
pollChoiceA.setDescriptionMap(pollChoiceDescriptionMapA);

choices.add(pollChoiceA);

Map<Locale, String> pollChoiceDescriptionMapB = new HashMap<Locale, String>();

pollChoiceDescriptionMapB.put(Locale.US, "No");

PollsChoice pollChoiceB = PollsChoiceUtil.create(0);

pollChoiceB.setName("b");
pollChoiceB.setDescriptionMap(pollChoiceDescriptionMapB);

choices.add(pollChoiceB);

PollsQuestion pollsQuestion = PollsQuestionLocalServiceUtil.addQuestion(
	userId, pollsDisplayTitleMap, pollsDisplayDescriptionMap, 0, 0, 0, 0, 0,
	true, choices, serviceContext)

PortletPreferences pollsDisplayPortletPreferences =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		pollsDisplayLayout.getPlid(), "59_INSTANCE_ContenPD0001",
		PortletConstants.DEFAULT_PREFERENCES);

pollsDisplayPortletPreferences.setValue(
	"questionId", String.valueOf(pollsQuestion.getQuestionId()));

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, pollsDisplayLayout.getPlid(),
	"59_INSTANCE_ContenPD0001", pollsDisplayPortletPreferences);

// Recent Downloads

Layout recentDownloadsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Recent Downloads", "", "", "portlet", false, "/recent-downloads",
	serviceContext);

LayoutTypePortlet recentDownloadsLayoutTypePortlet =
	(LayoutTypePortlet)recentDownloadsLayout.getLayoutType();

recentDownloadsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0010", "column-1", -1, false);
recentDownloadsLayoutTypePortlet.addPortletId(
	userId, "64", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, recentDownloadsLayout.getLayoutId(),
	recentDownloadsLayout.getTypeSettings());

// Related Assets

Layout relatedAssetsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Related Assets", "", "", "portlet", false, "/related-assets",
	serviceContext);

LayoutTypePortlet relatedAssetsLayoutTypePortlet =
	(LayoutTypePortlet)relatedAssetsLayout.getLayoutType();

relatedAssetsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0011", "column-1", -1, false);
relatedAssetsLayoutTypePortlet.addPortletId(
	userId, "175_INSTANCE_ContenRA0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, relatedAssetsLayout.getLayoutId(),
	relatedAssetsLayout.getTypeSettings());

// Site Map

Layout siteMapLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(), "Site Map",
	"", "", "portlet", false, "/site-map", serviceContext);

LayoutTypePortlet siteMapLayoutTypePortlet =
	(LayoutTypePortlet)siteMapLayout.getLayoutType();

siteMapLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0012", "column-1", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, siteMapLayout.getLayoutId(),
	siteMapLayout.getTypeSettings());

// Tag Cloud

Layout tagCloudLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(), "Tag Cloud",
	"", "", "portlet", false, "/tag-cloud", serviceContext);

LayoutTypePortlet tagCloudLayoutTypePortlet =
	(LayoutTypePortlet)tagCloudLayout.getLayoutType();

tagCloudLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0013", "column-1", -1, false);
tagCloudLayoutTypePortlet.addPortletId(
	userId, "148_INSTANCE_ContenTC0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, tagCloudLayout.getLayoutId(),
	tagCloudLayout.getTypeSettings());

// Tags Navigation

Layout tagsNavigationLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Tags Navigation", "", "", "portlet", false, "/tags-navigation",
	serviceContext);

LayoutTypePortlet tagsNavigationLayoutTypePortlet =
	(LayoutTypePortlet)tagsNavigationLayout.getLayoutType();

tagsNavigationLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0014", "column-1", -1, false);
tagsNavigationLayoutTypePortlet.addPortletId(
	userId, "141_INSTANCE_ContenTN0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, tagsNavigationLayout.getLayoutId(),
	tagsNavigationLayout.getTypeSettings());

// Web Content Display

Layout webContentDisplayLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Web Content Display", "", "", "portlet", false, "/web-content-display",
	serviceContext);

LayoutTypePortlet webContentDisplayLayoutTypePortlet =
	(LayoutTypePortlet)webContentDisplayLayout.getLayoutType();

webContentDisplayLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0015", "column-1", -1, false);
webContentDisplayLayoutTypePortlet.addPortletId(
	userId, "56_INSTANCE_ContenWCD001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, webContentDisplayLayout.getLayoutId(),
	webContentDisplayLayout.getTypeSettings());

Map<Locale, String> webContentArticleTitleMap = new HashMap<Locale, String>();

webContentArticleTitleMap.put(Locale.US, "Web Content Article Title");

Map<Locale, String> webContentArticleDescriptionMap =
	new HashMap<Locale, String>();

webContentArticleDescriptionMap.put(
	Locale.US, "Web content article description");

String webContentContent = "<?xml version=\"1.0\"?><root " +
	"available-locales=\"en_US\" default-locale=\"en_US\"><static-content " +
	"language-id=\"en_US\"><![CDATA[Lorem ipsum dolor sit amet, consectetur " +
	"adipisicing elit,sed do eiusmod tempor incididunt ut labore et dolore " +
	"magna aliqua.]]></static-content></root>";

JournalArticle webContentArticle = JournalArticleLocalServiceUtil.addArticle(
	userId, groupId, 0, 0, "", true, 1.0, webContentArticleTitleMap,
	webContentArticleDescriptionMap, webContentContent, "general", null, null,
	null, 0, 1, 2010, 12, 0, 0, 0, 0, 0, 0, true, 0, 0, 0, 0, 0, true, true,
	false, null, null, null, null, serviceContext);

PortletPreferences webContentDisplayPortletPreferences =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		webContentDisplayLayout.getPlid(), "56_INSTANCE_ContenWCD001",
		PortletConstants.DEFAULT_PREFERENCES);

webContentDisplayPortletPreferences.setValue(
	"articleId", String.valueOf(webContentArticle.getArticleId()));

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, webContentDisplayLayout.getPlid(),
	"56_INSTANCE_ContenWCD001", webContentDisplayPortletPreferences);

// Web Content List

Layout webContentListLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Web Content List", "", "", "portlet", false, "/web-content-list",
	serviceContext);

LayoutTypePortlet webContentListLayoutTypePortlet =
	(LayoutTypePortlet)webContentListLayout.getLayoutType();

webContentListLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0016", "column-1", -1, false);
webContentListLayoutTypePortlet.addPortletId(
	userId, "62_INSTANCE_ContenWCL001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, webContentListLayout.getLayoutId(),
	webContentListLayout.getTypeSettings());

PortletPreferences webContentListPortletPreferences =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		webContentListLayout.getPlid(), "62_INSTANCE_ContenWCL001",
		PortletConstants.DEFAULT_PREFERENCES);

webContentListPortletPreferences.setValue("groupId", String.valueOf(groupId));

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, webContentListLayout.getPlid(),
	"62_INSTANCE_ContenWCL001", webContentListPortletPreferences);

// Web Content Search

Layout webContentSearchLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Web Content Search", "", "", "portlet", false, "/web-content-search",
	serviceContext);

LayoutTypePortlet webContentSearchLayoutTypePortlet =
	(LayoutTypePortlet)webContentSearchLayout.getLayoutType();

webContentSearchLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0017", "column-1", -1, false);
webContentSearchLayoutTypePortlet.addPortletId(
	userId, "77", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, webContentSearchLayout.getLayoutId(),
	webContentSearchLayout.getTypeSettings());

// XSL Content

Layout xslContentLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"XSL Content", "", "", "portlet", false, "/xsl-content", serviceContext);

LayoutTypePortlet xslContentLayoutTypePortlet =
	(LayoutTypePortlet)xslContentLayout.getLayoutType();

xslContentLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ContenSM0018", "column-1", -1, false);
xslContentLayoutTypePortlet.addPortletId(
	userId, "102_INSTANCE_ContenXSLC01", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, xslContentLayout.getLayoutId(),
	xslContentLayout.getTypeSettings());

// Link parent page with first child page

UnicodeProperties contentManagementTypeSettingsProperties =
	contentManagementLayout.getTypeSettingsProperties();

contentManagementTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(assetPublisherLayout.getLayoutId()));

contentManagementLayout.setTypeSettingsProperties(
	contentManagementTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, contentManagementLayout.getLayoutId(),
	contentManagementLayout.getTypeSettings());