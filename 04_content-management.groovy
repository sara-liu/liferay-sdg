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
	userId, "85_INSTANCE_ConManSM0001", "column-1", -1, false);
assetPublisherLayoutTypePortlet.addPortletId(
	userId, "101_INSTANCE_ConManAP0001", "column-2", -1, false);

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
	userId, "85_INSTANCE_ConManSM0002", "column-1", -1, false);
breadcrumbLayoutTypePortlet.addPortletId(
	userId, "73_INSTANCE_ConManBC0001", "column-2", -1, false);

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
	userId, "85_INSTANCE_ConManSM0002", "column-1", -1, false);
categoriesNavigationLayoutTypePortlet.addPortletId(
	userId, "122_INSTANCE_ConManCN0001", "column-2", -1, false);

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
	userId, "85_INSTANCE_ConManSM0003", "column-1", -1, false);
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
	userId, "85_INSTANCE_ConManSM0004", "column-1", -1, false);
dmDisplayLayoutTypePortlet.addPortletId(
	userId, "110_INSTANCE_ConManDMDi01", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, dmDisplayLayout.getLayoutId(),
	dmDisplayLayout.getTypeSettings());

// Highest Rated Assets

Layout highestRatedAssetsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Highest Rated Assets", "", "", "portlet", false, "/highest-rated-assets",
	serviceContext);

LayoutTypePortlet highestRatedAssetsLayoutTypePortlet =
	(LayoutTypePortlet)highestRatedAssetsLayout.getLayoutType();

highestRatedAssetsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ConManSM0005", "column-1", -1, false);
highestRatedAssetsLayoutTypePortlet.addPortletId(
	userId, "194_INSTANCE_ConManHRA001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, highestRatedAssetsLayout.getLayoutId(),
	highestRatedAssetsLayout.getTypeSettings());

// Media Gallery

Layout mediaGalleryLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Media Gallery", "", "", "portlet", false, "/media-gallery",
	serviceContext);

LayoutTypePortlet mediaGalleryLayoutTypePortlet =
	(LayoutTypePortlet)mediaGalleryLayout.getLayoutType();

mediaGalleryLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ConManSM0006", "column-1", -1, false);
mediaGalleryLayoutTypePortlet.addPortletId(
	userId, "31_INSTANCE_ConManMG0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, mediaGalleryLayout.getLayoutId(),
	mediaGalleryLayout.getTypeSettings());

// Most Viewed Assets

Layout mostViewedAssetsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Most Viewed Assets", "", "", "portlet", false, "/most-viewed-assets",
	serviceContext);

LayoutTypePortlet mostViewedAssetsLayoutTypePortlet =
	(LayoutTypePortlet)mostViewedAssetsLayout.getLayoutType();

mostViewedAssetsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ConManSM0007", "column-1", -1, false);
mostViewedAssetsLayoutTypePortlet.addPortletId(
	userId, "193_INSTANCE_ConManMVA001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, mostViewedAssetsLayout.getLayoutId(),
	mostViewedAssetsLayout.getTypeSettings());

// Navigation

Layout navigationLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Navigation", "", "", "portlet", false, "/navigation", serviceContext);

LayoutTypePortlet navigationLayoutTypePortlet =
	(LayoutTypePortlet)navigationLayout.getLayoutType();

navigationLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ConManSM0008", "column-1", -1, false);
navigationLayoutTypePortlet.addPortletId(
	userId, "71_INSTANCE_ConManNav001", "column-2", -1, false);

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
	userId, "85_INSTANCE_ConManSM0009", "column-1", -1, false);
nestedPortletsLayoutTypePortlet.addPortletId(
	userId, "118_INSTANCE_ConManNP0001", "column-2", -1, false);
nestedPortletsLayoutTypePortlet.addPortletId(
	userId, "47", "_118_INSTANCE_ConManNP0001__column-1", -1, false);
nestedPortletsLayoutTypePortlet.addPortletId(
	userId, "50", "_118_INSTANCE_ConManNP0001__column-2", -1, false);

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
	userId, "85_INSTANCE_ConManSM0010", "column-1", -1, false);
pollsDisplayLayoutTypePortlet.addPortletId(
	userId, "59_INSTANCE_ConManPD0001", "column-2", -1, false);

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
		pollsDisplayLayout.getPlid(), "59_INSTANCE_ConManPD0001",
		PortletConstants.DEFAULT_PREFERENCES);

pollsDisplayPortletPreferences.setValue(
	"questionId", String.valueOf(pollsQuestion.getQuestionId()));

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, pollsDisplayLayout.getPlid(),
	"59_INSTANCE_ConManPD0001", pollsDisplayPortletPreferences);

// Recent Downloads

Layout recentDownloadsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Recent Downloads", "", "", "portlet", false, "/recent-downloads",
	serviceContext);

LayoutTypePortlet recentDownloadsLayoutTypePortlet =
	(LayoutTypePortlet)recentDownloadsLayout.getLayoutType();

recentDownloadsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ConManSM0011", "column-1", -1, false);
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
	userId, "85_INSTANCE_ConManSM0012", "column-1", -1, false);
relatedAssetsLayoutTypePortlet.addPortletId(
	userId, "175_INSTANCE_ConManRA0001", "column-2", -1, false);

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
	userId, "85_INSTANCE_ConManSM0013", "column-1", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, siteMapLayout.getLayoutId(),
	siteMapLayout.getTypeSettings());

// Sites Directory

Layout sitesDirectoryLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Sites Directory", "", "", "portlet", false, "/sites-directory",
	serviceContext);

LayoutTypePortlet sitesDirectoryLayoutTypePortlet =
	(LayoutTypePortlet)sitesDirectoryLayout.getLayoutType();

sitesDirectoryLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ConManSM0014", "column-1", -1, false);
sitesDirectoryLayoutTypePortlet.addPortletId(
	userId, "184_INSTANCE_ConManSD0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, sitesDirectoryLayout.getLayoutId(),
	sitesDirectoryLayout.getTypeSettings());

// Tag Cloud

Layout tagCloudLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(), "Tag Cloud",
	"", "", "portlet", false, "/tag-cloud", serviceContext);

LayoutTypePortlet tagCloudLayoutTypePortlet =
	(LayoutTypePortlet)tagCloudLayout.getLayoutType();

tagCloudLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ConManSM0015", "column-1", -1, false);
tagCloudLayoutTypePortlet.addPortletId(
	userId, "148_INSTANCE_ConManTC0001", "column-2", -1, false);

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
	userId, "85_INSTANCE_ConManSM0016", "column-1", -1, false);
tagsNavigationLayoutTypePortlet.addPortletId(
	userId, "141_INSTANCE_ConManTN0001", "column-2", -1, false);

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
	userId, "85_INSTANCE_ConManSM0017", "column-1", -1, false);
webContentDisplayLayoutTypePortlet.addPortletId(
	userId, "56_INSTANCE_ConManWCD001", "column-2", -1, false);

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
	userId, groupId, 0, webContentArticleTitleMap,
	webContentArticleDescriptionMap, webContentContent, null, null,
	serviceContext);

PortletPreferences webContentDisplayPortletPreferences =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		webContentDisplayLayout.getPlid(), "56_INSTANCE_ConManWCD001",
		PortletConstants.DEFAULT_PREFERENCES);

webContentDisplayPortletPreferences.setValue(
	"articleId", String.valueOf(webContentArticle.getArticleId()));

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, webContentDisplayLayout.getPlid(),
	"56_INSTANCE_ConManWCD001", webContentDisplayPortletPreferences);

// Web Content Search

Layout webContentSearchLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, contentManagementLayout.getLayoutId(),
	"Web Content Search", "", "", "portlet", false, "/web-content-search",
	serviceContext);

LayoutTypePortlet webContentSearchLayoutTypePortlet =
	(LayoutTypePortlet)webContentSearchLayout.getLayoutType();

webContentSearchLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ConManSM0018", "column-1", -1, false);
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
	userId, "85_INSTANCE_ConManSM0019", "column-1", -1, false);
xslContentLayoutTypePortlet.addPortletId(
	userId, "102_INSTANCE_ConManXSLC01", "column-2", -1, false);

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