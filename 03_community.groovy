import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.bookmarks.model.BookmarksFolder;
import com.liferay.portlet.bookmarks.service.BookmarksEntryLocalServiceUtil;
import com.liferay.portlet.bookmarks.service.BookmarksFolderLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.ratings.service.RatingsEntryLocalServiceUtil;

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

	assetCategorys = AssetCategoryLocalServiceUtil.getVocabularyCategories(
		assetVocabulary.getVocabularyId(), -1, -1, null);
}
catch (Exception e) {
}

// Community

Layout communityLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Community", "", "", "link_to_layout", false,
	"/community", serviceContext);

// Bookmarks

Layout bookmarksLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, communityLayout.getLayoutId(), "Bookmarks", "", "",
	"portlet", false, "/bookmarks", serviceContext);

LayoutTypePortlet bookmarksLayoutTypePortlet =
	(LayoutTypePortlet)bookmarksLayout.getLayoutType();

bookmarksLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CommunSM0001", "column-1", -1, false);
bookmarksLayoutTypePortlet.addPortletId(userId, "28", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, bookmarksLayout.getLayoutId(),
	bookmarksLayout.getTypeSettings());

BookmarksFolder bookmarkFolder = BookmarksFolderLocalServiceUtil.addFolder(
	userId, 0, "Bookmark Folder Name", "Bookmark folder description",
	serviceContext);

BookmarksEntry bookmarksEntry = BookmarksEntryLocalServiceUtil.addEntry(
	userId, groupId, bookmarkFolder.getFolderId(), "Bookmark Name",
	"http://www.example.com", "Bookmark description", serviceContext);

long[] bookmarksCategoryIds = null;

if (assetCategories != null) {
	bookmarksCategoryIds = [
		assetCategories[0].getCategoryId(), assetCategories[1].getCategoryId()
	];
}

AssetEntryLocalServiceUtil.updateEntry(
	userId, groupId, "com.liferay.portlet.bookmarks.model.BookmarksEntry",
	bookmarksEntry.getEntryId(), bookmarksCategoryIds, null);

// Directory

Layout directoryLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, communityLayout.getLayoutId(), "Directory", "", "",
	"portlet", false, "/directory", serviceContext);

LayoutTypePortlet directoryLayoutTypePortlet =
	(LayoutTypePortlet)directoryLayout.getLayoutType();

directoryLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CommunSM0002", "column-1", -1, false);
directoryLayoutTypePortlet.addPortletId(userId, "11", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, directoryLayout.getLayoutId(),
	directoryLayout.getTypeSettings());

OrganizationLocalServiceUtil.addOrganization(
	userId, 0, "Organizations Name", "regular-organization", true, 0, 0,
	ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, null, false, serviceContext);

UserGroupLocalServiceUtil.addUserGroup(
	userId, companyId, "User Group Name", "User group description");

// Invitation

Layout invitationLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, communityLayout.getLayoutId(), "Invitation", "", "",
	"portlet", false, "/invitation", serviceContext);

LayoutTypePortlet invitationLayoutTypePortlet =
	(LayoutTypePortlet)invitationLayout.getLayoutType();

invitationLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CommunSM0003", "column-1", -1, false);
invitationLayoutTypePortlet.addPortletId(userId, "100", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, invitationLayout.getLayoutId(),
	invitationLayout.getTypeSettings());

// My Sites

Layout mySitesLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, communityLayout.getLayoutId(), "My Sites", "", "",
	"portlet", false, "/my-sites", serviceContext);

LayoutTypePortlet mySitesLayoutTypePortlet =
	(LayoutTypePortlet)mySitesLayout.getLayoutType();

mySitesLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CommunSM0004", "column-1", -1, false);
mySitesLayoutTypePortlet.addPortletId(userId, "29", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, mySitesLayout.getLayoutId(),
	mySitesLayout.getTypeSettings());

// Page Comments

Layout pageCommentsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, communityLayout.getLayoutId(), "Page Comments", "",
	"", "portlet", false, "/page-comments", serviceContext);

LayoutTypePortlet pageCommentsLayoutTypePortlet =
	(LayoutTypePortlet)pageCommentsLayout.getLayoutType();

pageCommentsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CommunSM0005", "column-1", -1, false);
pageCommentsLayoutTypePortlet.addPortletId(
	userId, "107", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, pageCommentsLayout.getLayoutId(),
	pageCommentsLayout.getTypeSettings());

MBMessageDisplay discussionMessageDisplay = 
	MBMessageLocalServiceUtil.getDiscussionMessageDisplay(
		userId, groupId, "com.liferay.portal.model.Layout",
		pageCommentsLayout.getPlid(), 0);

MBMessage commentMessage = discussionMessageDisplay.getMessage();

MBMessageLocalServiceUtil.addDiscussionMessage(
	userId, null, groupId, "com.liferay.portal.model.Layout",
	pageCommentsLayout.getPlid(), commentMessage.getThreadId(),
	commentMessage.getMessageId(), "Page Comment Subject",
	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
		"eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	serviceContext);

// Page Flags

Layout pageFlagsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, communityLayout.getLayoutId(), "Page Flags", "", "",
	"portlet", false, "/page-flags", serviceContext);

LayoutTypePortlet pageFlagsLayoutTypePortlet =
	(LayoutTypePortlet)pageFlagsLayout.getLayoutType();

pageFlagsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CommunSM0006", "column-1", -1, false);
pageFlagsLayoutTypePortlet.addPortletId(userId, "143", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, pageFlagsLayout.getLayoutId(),
	pageFlagsLayout.getTypeSettings());

// Page Ratings

Layout pageRatingsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, communityLayout.getLayoutId(), "Page Ratings", "",
	"", "portlet", false, "/page-ratings", serviceContext);

LayoutTypePortlet pageRatingsLayoutTypePortlet =
	(LayoutTypePortlet)pageRatingsLayout.getLayoutType();

pageRatingsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CommunSM0007", "column-1", -1, false);
pageRatingsLayoutTypePortlet.addPortletId(userId, "108", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, pageRatingsLayout.getLayoutId(),
	pageRatingsLayout.getTypeSettings());

RatingsEntryLocalServiceUtil.updateEntry(
	userId, "com.liferay.portal.model.Layout", pageRatingsLayout.getPlid(), 4.0,
	serviceContext);

// Link parent page with first child page

UnicodeProperties communityTypeSettingsProperties =
	communityLayout.getTypeSettingsProperties();

communityTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(bookmarksLayout.getLayoutId()));

communityLayout.setTypeSettingsProperties(
	communityTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, communityLayout.getLayoutId(),
	communityLayout.getTypeSettings());