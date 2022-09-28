const { test } = require('@playwright/test');
const { Homepage } = require('../pages/Homepage.js');
const { SearchPage } = require('../pages/SearchPage.js');
const { Header } = require('../pages/components/Header.js');
const { dotenv } = require('dotenv').config();
const data = require('../data/data.json');

let homepage;
let header;
let searchPage;

test.describe('Search', () => {

    test.beforeEach(async ({ page }) => {
        homepage = new Homepage(page);
        header = new Header(page);
        searchPage = new SearchPage(page);
        await homepage.gotoPage();
    });

    test('Search with results', async ({ page }) => {
        await header.typeKeywords(data.searches.yellowdress.keywords);
        await header.clickSearchButton();
        await searchPage.validateNumberOfResults(data.searches.yellowdress.results, data.texts.resultsFound);
    });

    test('Search with no results', async ({ page }) => {
        await header.typeKeywords(data.searches.labordress.keywords);
        await header.clickSearchButton();
        await searchPage.validateNoResultsFound(data.searches.labordress.results, data.errors.noSearchResultsFound);
    });

});
