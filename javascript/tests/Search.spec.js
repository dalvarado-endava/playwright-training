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


    data.searches.withNoResults.forEach(search => {
        test(`Search "${search.keywords}" with no results`, async ({ page }) => {

            await test.step('Type keywords to search', async () =>
                await header.typeKeywords(search.keywords))

            await test.step('Click the search button', async () =>
                await header.clickSearchButton())

            await test.step('Validate no search results found', async () =>
                await searchPage.validateNoResultsFound(search.results, data.texts.noSearchResultsFound))
        });
    });


    data.searches.withOneResult.forEach(search => {
        test(`Search "${search.keywords}" with one result`, async ({ page }) => {

            await test.step('Type keywords to search', async () =>
                await header.typeKeywords(search.keywords))

            await test.step('Click the search button', async () =>
                await header.clickSearchButton())

            await test.step('Validate number of search results', async () =>
                await searchPage.validateNumberOfResults(search.results, data.texts.oneResultFound))
        });
    });


    data.searches.withManyResults.forEach(search => {
        test(`Search "${search.keywords}" with many results`, async ({ page }) => {

            await test.step('Type keywords to search', async () =>
                await header.typeKeywords(search.keywords))

            await test.step('Click the search button', async () =>
                await header.clickSearchButton())

            await test.step('Validate number of search results', async () =>
                await searchPage.validateNumberOfResults(search.results, data.texts.manyResultsFound))
        });
    });

});
