package utils;

public enum TestDataPaths {

    POLICIES_LIST("src/test/resources/testData/policiesList.txt"),
    MAIN_PAGE_TITLE("src/test/resources/testData/mainPageTitle.txt"),
    SORTING_OF_ITEMS("src/test/resources/testData/sortingOfItems.txt"),
    CORP_OVERVIEW_FILE_NAME("src/test/resources/testData/corpOverviewFileNames.txt"),
    COMPUTERS_LIST("src/test/resources/testData/computersCategoryList.txt"),
    REGION_LIST("src/test/resources/testData/regionList.txt");

    private final String path;

    TestDataPaths(String path) {
        this.path= path;
    }
    public String getPath() {
        return path;
    }
}
