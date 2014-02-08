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
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.wiki.DuplicateNodeNameException;
import com.liferay.portlet.wiki.model.WikiNode;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiNodeLocalServiceUtil;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;

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

AssetVocabulary assetVocabulary = null;
List<AssetCategory> assetCategories = null;

try {
	assetVocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(
		groupId, "Topic");

	assetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(
		assetVocabulary.getVocabularyId(), -1, -1, null);
}
catch (Exception e) {
}

// Collaboration

Layout collaborationLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Collaboration", "", "", "link_to_layout", false,
	"/collaboration", serviceContext);

// Blogs

Layout blogsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "Blogs", "", "",
	"portlet", false, "/blogs", serviceContext);

LayoutTypePortlet blogsLayoutTypePortlet =
	(LayoutTypePortlet)blogsLayout.getLayoutType();

blogsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0001", "column-1", -1, false);
blogsLayoutTypePortlet.addPortletId(userId, "33", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, blogsLayout.getLayoutId(), blogsLayout.getTypeSettings());

BlogsEntry blogsEntry = BlogsEntryLocalServiceUtil.addEntry(
	userId, "Blog Title", "Blog description",
	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
		"eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	0, 1, 2010, 12, 0, true, false, new String[0], false, "", "", null,
	serviceContext);

long[] blogsCategoryIds = null;

if (assetCategories != null) {
	blogsCategoryIds = [assetCategories[0].getCategoryId()];
}

String[] blogsTagNames = ["tag1", "tag2"];

AssetEntryLocalServiceUtil.updateEntry(
	userId, groupId, "com.liferay.portlet.blogs.model.BlogsEntry",
	blogsEntry.getEntryId(), blogsCategoryIds, blogsTagNames);

// Blogs Aggregator

Layout blogsAggregatorLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(),
	"Blogs Aggregator", "", "", "portlet", false, "/blogs-aggregator",
	serviceContext);

LayoutTypePortlet blogsAggregatorLayoutTypePortlet =
	(LayoutTypePortlet)blogsAggregatorLayout.getLayoutType();

blogsAggregatorLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0002", "column-1", -1, false);
blogsAggregatorLayoutTypePortlet.addPortletId(
	userId, "115", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, blogsAggregatorLayout.getLayoutId(),
	blogsAggregatorLayout.getTypeSettings());

// Calendar

Layout CalendarLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(),
	"Calendar", "", "", "portlet", false, "/calendar", serviceContext);

LayoutTypePortlet calendarLayoutTypePortlet =
	(LayoutTypePortlet)CalendarLayout.getLayoutType();

calendarLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0003", "column-1", -1, false);
calendarLayoutTypePortlet.addPortletId(userId, "8", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, CalendarLayout.getLayoutId(),
	CalendarLayout.getTypeSettings());

CalEventLocalServiceUtil.addEvent(
	userId, "Calendar Title", "Calendar description", "Calendar Location", 1,
	10, 2014, 0, 0, 0, 0, true, false, "anniversary", false, null, 1, 900000,
	300000, serviceContext);

// Dynamic Data List Display 

Layout ddlDisplayLayout1 = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "DDL Display 1",
	"", "", "portlet", false, "/ddl-display-1", serviceContext);

LayoutTypePortlet ddlDisplayLayoutTypePortlet1 =
	(LayoutTypePortlet)ddlDisplayLayout1.getLayoutType();

ddlDisplayLayoutTypePortlet1.addPortletId(
	userId, "85_INSTANCE_CollabSM0004", "column-1", -1, false);
ddlDisplayLayoutTypePortlet1.addPortletId(
	userId, "169_INSTANCE_CollabDDLD01", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, ddlDisplayLayout1.getLayoutId(),
	ddlDisplayLayout1.getTypeSettings());

DDMStructure ddmStructure = DDMStructureLocalServiceUtil.getStructure(
	groupId, "CONTACTS");

Map<Locale, String> ddmRecordSetNameMap = new HashMap<Locale, String>();

ddmRecordSetNameMap.put(Locale.US, "DDL Record Set Name");

Map<Locale, String> ddmRecordSetDescriptionMap = new HashMap<Locale, String>();

ddmRecordSetDescriptionMap.put(Locale.US, "DDL record set description");

DDLRecordSet ddlRecordSet = DDLRecordSetLocalServiceUtil.addRecordSet(
	userId, groupId, ddmStructure.getStructureId(), null, ddmRecordSetNameMap,
	ddmRecordSetDescriptionMap, 10, 0, serviceContext);

Fields ddmFields = DDMUtil.getFields(
	ddmStructure.getStructureId(), serviceContext);

DDLRecordLocalServiceUtil.addRecord(
	userId, groupId, ddlRecordSet.getRecordSetId(), 0, ddmFields,
	serviceContext);

PortletPreferences ddlDisplayPortletPreferences1 =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		ddlDisplayLayout1.getPlid(), "169_INSTANCE_CollabDDLD01",
		PortletConstants.DEFAULT_PREFERENCES);

ddlDisplayPortletPreferences1.setValue(
	"recordSetId", String.valueOf(ddlRecordSet.getRecordSetId()));

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, ddlDisplayLayout1.getPlid(),
	"169_INSTANCE_CollabDDLD01", ddlDisplayPortletPreferences1);

// Dynamic Data List Display (Spreadsheet View)

Layout ddlDisplayLayout2 = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "DDL Display 2",
	"", "", "portlet", false, "/ddl-display-2", serviceContext);

LayoutTypePortlet ddlDisplayLayoutTypePortlet2 =
	(LayoutTypePortlet)ddlDisplayLayout2.getLayoutType();

ddlDisplayLayoutTypePortlet2.addPortletId(
	userId, "85_INSTANCE_CollabSM0005", "column-1", -1, false);
ddlDisplayLayoutTypePortlet2.addPortletId(
	userId, "169_INSTANCE_CollabDDLD02", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, ddlDisplayLayout2.getLayoutId(),
	ddlDisplayLayout2.getTypeSettings());

PortletPreferences ddlDisplayPortletPreferences2 =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		ddlDisplayLayout2.getPlid(), "169_INSTANCE_CollabDDLD02",
		PortletConstants.DEFAULT_PREFERENCES);

ddlDisplayPortletPreferences2.setValue(
	"recordSetId", String.valueOf(ddlRecordSet.getRecordSetId()));
ddlDisplayPortletPreferences2.setValue("spreadsheet", "true");

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, ddlDisplayLayout2.getPlid(),
	"169_INSTANCE_CollabDDLD02", ddlDisplayPortletPreferences2);

// Message Boards

Layout mbLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "Message Boards",
	"", "", "portlet", false, "/message-boards", serviceContext);

LayoutTypePortlet mbLayoutTypePortlet =
	(LayoutTypePortlet)mbLayout.getLayoutType();

mbLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0006", "column-1", -1, false);
mbLayoutTypePortlet.addPortletId(userId, "19", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, mbLayout.getLayoutId(), mbLayout.getTypeSettings());

MBCategory mbCategory = MBCategoryLocalServiceUtil.addCategory(
	userId, 0, "MB Category Name", "MB category description", "default", null,
	null, null, 0, false, null, null, 0, null, false, null, 0, false, null,
	null, false, false, serviceContext);

MBMessage mbMessage = MBMessageLocalServiceUtil.addMessage(
	userId, "Test Test", groupId, mbCategory.getCategoryId(),
	"MB Message Subject",
	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
		"eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"bbcode", new ArrayList(), false, 0.0, true, serviceContext);

String[] mbMessageTagNames = ["tag1"];

AssetEntryLocalServiceUtil.updateEntry(
	userId, groupId, "com.liferay.portlet.messageboards.model.MBMessage",
	mbMessage.getMessageId(), null, mbMessageTagNames);

MBCategory mbQuestionCategory = MBCategoryLocalServiceUtil.addCategory(
	userId, 0, "MB Question Category Name", "MB question category description",
	"question", null, null, null, 0, false, null, null, 0, null, false, null, 0,
	false, null, null, false, false, serviceContext);

MBMessage mbQuestionMessage = MBMessageLocalServiceUtil.addMessage(
	userId, "Test Test", groupId, mbQuestionCategory.getCategoryId(),
	"MB Question Message Subject",
	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
		"eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"bbcode", new ArrayList(), false, 0.0, true, serviceContext);

MBThreadLocalServiceUtil.updateQuestion(mbQuestionMessage.getThreadId(), true);

// Recent Bloggers

Layout recentBloggersLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(),
	"Recent Bloggers", "", "", "portlet", false, "/recent-bloggers",
	serviceContext);

LayoutTypePortlet recentBloggersLayoutTypePortlet =
	(LayoutTypePortlet)recentBloggersLayout.getLayoutType();

recentBloggersLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0007", "column-1", -1, false);
recentBloggersLayoutTypePortlet.addPortletId(
	userId, "114", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, recentBloggersLayout.getLayoutId(),
	recentBloggersLayout.getTypeSettings());

// Wiki

Layout wikiLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "Wiki", "", "",
	"portlet", false, "/wiki", serviceContext);

LayoutTypePortlet wikiLayoutTypePortlet =
	(LayoutTypePortlet)wikiLayout.getLayoutType();

wikiLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0008", "column-1", -1, false);
wikiLayoutTypePortlet.addPortletId(userId, "36", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, wikiLayout.getLayoutId(), wikiLayout.getTypeSettings());

WikiNode wikiNode = null;

try {
	wikiNode = WikiNodeLocalServiceUtil.addNode(
		userId, "Main", "", serviceContext);
}
catch (DuplicateNodeNameException dnne) {
	wikiNode = WikiNodeLocalServiceUtil.getNode(groupId, "Main");
}

double wikiPageVersion = 1.0;

WikiPage wikiPage = null;

try {
	wikiPage = WikiPageLocalServiceUtil.getLatestPage(
		wikiNode.getNodeId(), "FrontPage", 0, true);

	wikiPageVersion = wikiPage.getVersion();
}
catch (Exception e) {
}

wikiPage = WikiPageLocalServiceUtil.updatePage(
	userId, wikiNode.getNodeId(), "FrontPage", wikiPageVersion,
	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
		"eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"Wiki page change summary", false, "creole", "", "", serviceContext);

long[] wikiPageCategoryIds = null;

if (assetCategories != null) {
	wikiPageCategoryIds = [assetCategories[1].getCategoryId()];
}

String[] wikiPageTagNames = ["tag2"];

AssetEntryLocalServiceUtil.updateEntry(
	userId, groupId, "com.liferay.portlet.wiki.model.WikiPage",
	wikiPage.getResourcePrimKey(), wikiPageCategoryIds, wikiPageTagNames);

// Wiki Display

Layout wikiDisplayLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "Wiki Display",
	"", "", "portlet", false, "/wiki-display", serviceContext);

LayoutTypePortlet wikiDisplayLayoutTypePortlet =
	(LayoutTypePortlet)wikiDisplayLayout.getLayoutType();

wikiDisplayLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0009", "column-1", -1, false);
wikiDisplayLayoutTypePortlet.addPortletId(
	userId, "54_INSTANCE_CollabWD0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, wikiDisplayLayout.getLayoutId(),
	wikiDisplayLayout.getTypeSettings());

PortletPreferences wikiDisplayPortletPreferences =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		wikiDisplayLayout.getPlid(), "54_INSTANCE_CollabWD0001",
		PortletConstants.DEFAULT_PREFERENCES);

wikiDisplayPortletPreferences.setValue(
	"nodeId", String.valueOf(wikiNode.getNodeId()));
wikiDisplayPortletPreferences.setValue("title", "FrontPage");

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, wikiDisplayLayout.getPlid(),
	"54_INSTANCE_CollabWD0001", wikiDisplayPortletPreferences);

// Link parent page with first child page

UnicodeProperties collaborationTypeSettingsProperties =
	collaborationLayout.getTypeSettingsProperties();

collaborationTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(blogsLayout.getLayoutId()));

collaborationLayout.setTypeSettingsProperties(
	collaborationTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, collaborationLayout.getLayoutId(),
	collaborationLayout.getTypeSettings());

// Add related assets

AssetEntry blogsAssetEntry = AssetEntryLocalServiceUtil.getEntry(
	"com.liferay.portlet.blogs.model.BlogsEntry", blogsEntry.getEntryId());
AssetEntry messageBoardsAssetEntry = AssetEntryLocalServiceUtil.getEntry(
	"com.liferay.portlet.messageboards.model.MBMessage",
	mbMessage.getMessageId());
AssetEntry wikiPageAssetEntry = AssetEntryLocalServiceUtil.getEntry(
	"com.liferay.portlet.wiki.model.WikiPage", wikiPage.getResourcePrimKey());

AssetLinkLocalServiceUtil.addLink(
	userId, blogsAssetEntry.getEntryId(), messageBoardsAssetEntry.getEntryId(),
	0, 0);
AssetLinkLocalServiceUtil.addLink(
	userId, blogsAssetEntry.getEntryId(), wikiPageAssetEntry.getEntryId(), 0,
	0);