

# CompanySearchCriteria

The company-side filter blob, one field per ``CompanySearchFilters`` key.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**companyName** | **String** | Company name match. |  [optional] |
|**companyNameMatchType** | [**CompanyNameMatchTypeEnum**](#CompanyNameMatchTypeEnum) | How company_name matches: contains (substring), exact, or similar (word-order-free fuzzy). |  [optional] |
|**domain** | **String** | Company website domain; a pasted URL is reduced to its host. |  [optional] |
|**industriesInclude** | **List&lt;String&gt;** | LinkedIn industries or industry group names to include. |  [optional] |
|**headcountRanges** | **List&lt;String&gt;** | Headcount buckets to include (1-10 through 10001+), OR-ed. |  [optional] |
|**revenueMin** | **String** | Minimum estimated annual revenue in USD. |  [optional] |
|**revenueMax** | **String** | Maximum estimated annual revenue in USD. |  [optional] |
|**yearFoundedMin** | **String** | Earliest founding year, inclusive. |  [optional] |
|**yearFoundedMax** | **String** | Latest founding year, inclusive. |  [optional] |
|**companyType** | **List&lt;String&gt;** | Canonical LinkedIn company types to include. |  [optional] |
|**fundingRoundTypes** | **List&lt;String&gt;** | Last funding round labels to include, such as &#39;Series B&#39;. |  [optional] |
|**fundingAmountMin** | **String** | Total disclosed investment must exceed this USD amount. |  [optional] |
|**growthMin** | **String** | Six-month employee growth percent must exceed this value. |  [optional] |
|**growthMax** | **String** | Six-month employee growth percent must be below this value. |  [optional] |
|**industriesExclude** | **List&lt;String&gt;** | LinkedIn industries or industry group names to exclude. |  [optional] |
|**headcountRangesExclude** | **List&lt;String&gt;** | Headcount buckets to exclude. |  [optional] |
|**companyTypeExclude** | **List&lt;String&gt;** | Canonical LinkedIn company types to exclude. |  [optional] |
|**hqCountriesIso3** | **List&lt;String&gt;** | HQ countries as ISO-3 codes, country names or group names. |  [optional] |
|**hqCountriesIso3Exclude** | **List&lt;String&gt;** | HQ countries to exclude, same forms as hq_countries_iso3. |  [optional] |
|**largestHeadcountCountriesIso3** | **List&lt;String&gt;** | Countries holding most employees, same forms as hq_countries_iso3. |  [optional] |
|**hqStates** | **List&lt;String&gt;** | HQ state substrings such as &#39;Texas, United States&#39;, OR-ed. |  [optional] |
|**hqStatesExclude** | **List&lt;String&gt;** | HQ state substrings to exclude. |  [optional] |
|**hqCities** | **List&lt;String&gt;** | HQ city substrings such as &#39;Austin, Texas, United States&#39;, OR-ed. |  [optional] |
|**hqCitiesExclude** | **List&lt;String&gt;** | HQ city substrings to exclude. |  [optional] |
|**linkedinCategoriesInclude** | **List&lt;String&gt;** | LinkedIn category tags to include. |  [optional] |
|**crunchbaseCategoriesInclude** | **List&lt;String&gt;** | Crunchbase categories to include. |  [optional] |
|**crunchbaseCategoriesExclude** | **List&lt;String&gt;** | Crunchbase categories to exclude. |  [optional] |
|**stockListings** | **List&lt;String&gt;** | Stock exchange listings; PRIVATE selects unlisted companies. |  [optional] |
|**headcountLatestMin** | **String** | Minimum tracked employee count; overrides headcount buckets. |  [optional] |
|**headcountLatestMax** | **String** | Maximum tracked employee count; overrides headcount buckets. |  [optional] |
|**growth1mMin** | **String** | Minimum one-month employee growth percent. |  [optional] |
|**growth3mMin** | **String** | Minimum three-month employee growth percent. |  [optional] |
|**growth12mMin** | **String** | Minimum twelve-month employee growth percent. |  [optional] |
|**followersMin** | **String** | Minimum LinkedIn follower count. |  [optional] |
|**followersGrowth6mMin** | **String** | Minimum six-month follower growth percent. |  [optional] |
|**followersGrowth12mMin** | **String** | Minimum twelve-month follower growth percent. |  [optional] |
|**lastFundingDateAfter** | **String** | Last funding date floor as YYYY-MM-DD. |  [optional] |
|**ipoDateAfter** | **String** | IPO date floor as YYYY-MM-DD. |  [optional] |
|**lastFundingRoundAmountMin** | **String** | Minimum size of the last funding round in USD. |  [optional] |
|**lastFundingRoundAmountMax** | **String** | Maximum size of the last funding round in USD. |  [optional] |
|**bootstrappedOnly** | **Boolean** | Only companies with no disclosed investment. |  [optional] |
|**acquiredOnly** | **Boolean** | Only acquired companies. |  [optional] |
|**fundingRoundTypesExclude** | **List&lt;String&gt;** | Last funding round labels to exclude. |  [optional] |
|**investorsInclude** | **List&lt;String&gt;** | Crunchbase investors to include. |  [optional] |
|**investorsExclude** | **List&lt;String&gt;** | Crunchbase investors to exclude. |  [optional] |
|**stockSymbols** | **List&lt;String&gt;** | Stock ticker symbols to include. |  [optional] |
|**domainsList** | **List&lt;String&gt;** | Exact company domains to match; URLs are reduced to hosts. |  [optional] |
|**companyNamesList** | **List&lt;String&gt;** | Exact, case-sensitive company names to match. |  [optional] |
|**twitterHandle** | **String** | Exact Twitter handle; a leading @ is kept. |  [optional] |
|**descriptionKeyword** | **String** | Keyword matched against the LinkedIn company description. |  [optional] |
|**updatedAfter** | **String** | Crustdata updated_at floor, sent verbatim. |  [optional] |
|**compositeMode** | **Boolean** | UI-only flag from the composite section; never compiled. |  [optional] |
|**workforceRules** | [**List&lt;WorkforceRule&gt;**](WorkforceRule.md) | AND-combined role rules: percent, growth_6m or growth_yoy, with &gt;&#x3D; or &lt;&#x3D; and a finite threshold. Growth thresholds may be negative. |  [optional] |
|**excludeCompanyDomains** | **List&lt;String&gt;** | Company domains to exclude; resolved by the exclusions step. |  [optional] |
|**excludeInCleanlist** | [**ExcludeInCleanlistEnum**](#ExcludeInCleanlistEnum) | Skip companies already on the user&#39;s lists: off, any list they can open, or specific lists. |  [optional] |
|**excludeInCleanlistListIds** | **List&lt;String&gt;** | Lead list ids the list scope resolves against. |  [optional] |
|**crmFilterSections** | [**CrmFilterSections**](CrmFilterSections.md) | Per-CRM exclude clauses resolved by the exclusions step; conditions that exclude accounts only. |  [optional] |



## Enum: CompanyNameMatchTypeEnum

| Name | Value |
|---- | -----|
| CONTAINS | &quot;contains&quot; |
| EXACT | &quot;exact&quot; |
| SIMILAR | &quot;similar&quot; |



## Enum: ExcludeInCleanlistEnum

| Name | Value |
|---- | -----|
| OFF | &quot;off&quot; |
| ANY | &quot;any&quot; |
| LIST | &quot;list&quot; |



