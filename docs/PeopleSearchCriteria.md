

# PeopleSearchCriteria

``SearchFilters``: the People Finder's filter blob, one field per control.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**industriesInclude** | **List&lt;String&gt;** | Current employer industries to include: LinkedIn industry names or industry group tokens, which expand to their member industries. |  [optional] |
|**industriesExclude** | **List&lt;String&gt;** | Current employer industries to exclude: LinkedIn industry names or industry group tokens. |  [optional] |
|**companySizes** | **List&lt;String&gt;** | Current employer headcount buckets, e.g. 51-200 or 501-1,000. |  [optional] |
|**seniority** | **List&lt;String&gt;** | Current seniority levels, e.g. Director or Vice President. |  [optional] |
|**jobTitlesInclude** | **List&lt;String&gt;** | Current job titles to match; abbreviations expand to synonyms unless the match type is exact. |  [optional] |
|**jobTitlesExclude** | **List&lt;String&gt;** | Current job titles to exclude, matched exactly. |  [optional] |
|**jobTitleMatchType** | [**JobTitleMatchTypeEnum**](#JobTitleMatchTypeEnum) | How job titles match: contains (substring), exact, or similar. |  [optional] |
|**yearsOfExperience** | **String** | Total experience bucket: 0-1, 1-2, 3-5, 6-10 or 10+. |  [optional] |
|**contactCountries** | **List&lt;String&gt;** | Person countries to include: iso3 codes, country names or group tokens such as EMEA. |  [optional] |
|**contactCountriesExclude** | **List&lt;String&gt;** | Person countries to exclude, in any spelling the include accepts. |  [optional] |
|**contactRegions** | **List&lt;String&gt;** | Person states or regions to include, e.g. \&quot;Texas, United States\&quot;. |  [optional] |
|**contactRegionsExclude** | **List&lt;String&gt;** | Person states or regions to exclude. |  [optional] |
|**contactCities** | **List&lt;String&gt;** | Person cities to include, e.g. \&quot;Austin, Texas, United States\&quot;. |  [optional] |
|**contactCitiesExclude** | **List&lt;String&gt;** | Person cities to exclude. |  [optional] |
|**companyCountries** | **List&lt;String&gt;** | Current employer HQ countries to include. |  [optional] |
|**companyCountriesExclude** | **List&lt;String&gt;** | Current employer HQ countries to exclude. |  [optional] |
|**companyRegions** | **List&lt;String&gt;** | Current employer HQ states or regions to include. |  [optional] |
|**companyRegionsExclude** | **List&lt;String&gt;** | Current employer HQ states or regions to exclude. |  [optional] |
|**companyCities** | **List&lt;String&gt;** | Current employer HQ cities to include. |  [optional] |
|**companyCitiesExclude** | **List&lt;String&gt;** | Current employer HQ cities to exclude. |  [optional] |
|**skills** | **List&lt;String&gt;** | Skills listed on the profile, substring matched. |  [optional] |
|**connectionsMin** | **String** | Minimum number of LinkedIn connections. |  [optional] |
|**connectionsMax** | **String** | Maximum number of LinkedIn connections. |  [optional] |
|**degreeTypes** | **List&lt;String&gt;** | Degree types, e.g. MBA or PhD. |  [optional] |
|**schoolNames** | **List&lt;String&gt;** | Institution names, matched exactly. |  [optional] |
|**fieldsOfStudy** | **List&lt;String&gt;** | Fields of study, matched exactly. |  [optional] |
|**certificationKeywords** | **List&lt;String&gt;** | Certification names, matched exactly. |  [optional] |
|**companyNameFilter** | **String** | One current employer name, ANDed. |  [optional] |
|**companyNameMatchType** | [**CompanyNameMatchTypeEnum**](#CompanyNameMatchTypeEnum) | How employer NAMES match — governs both company_name_filter and current_company_names: contains (substring), exact, or similar. Domains and LinkedIn URLs are always exact. |  [optional] |
|**firstName** | **String** | First name, exact. |  [optional] |
|**lastName** | **String** | Last name, exact. |  [optional] |
|**linkedinUrls** | **List&lt;String&gt;** | Person LinkedIn vanity URLs; any of them matches. |  [optional] |
|**pastCompanies** | **List&lt;String&gt;** | Past employer names, substring matched. |  [optional] |
|**pastTitles** | **List&lt;String&gt;** | Past job titles, substring matched. |  [optional] |
|**yearsAtCompany** | **String** | Years in the current role bucket: 0-1, 1-2, 2-5, 5-10 or 10+. |  [optional] |
|**recentlyChangedJobs** | **Boolean** | Only people who changed jobs recently. |  [optional] |
|**currentCompanyLinkedInUrls** | **List&lt;String&gt;** | Current employer LinkedIn company URLs; ORed with domains and names. |  [optional] |
|**currentCompanyDomains** | **List&lt;String&gt;** | Current employer website domains; ORed with URLs and names. |  [optional] |
|**currentCompanyNames** | **List&lt;String&gt;** | Current employer names; ORed with URLs and domains. |  [optional] |
|**pastCompanyLinkedInUrls** | **List&lt;String&gt;** | Past employer LinkedIn company URLs. |  [optional] |
|**functionCategoriesInclude** | **List&lt;String&gt;** | Current job functions, e.g. Engineering or Sales. |  [optional] |
|**pastFunctionCategoriesInclude** | **List&lt;String&gt;** | Past job functions. |  [optional] |
|**pastSeniority** | **List&lt;String&gt;** | Past seniority levels. |  [optional] |
|**pastCompaniesRequireAll** | **Boolean** | When true, every past company and past company URL must appear in the person&#39;s history instead of any one of them. |  [optional] |
|**neverWorkedAtCompanies** | **List&lt;String&gt;** | LinkedIn company URLs the person must never have worked at; unsupported values are rejected. |  [optional] |
|**neverHeldTitles** | **List&lt;String&gt;** | Titles the person must never have held, matched exactly. |  [optional] |
|**followersMin** | **String** | Minimum number of followers. |  [optional] |
|**followersMax** | **String** | Maximum number of followers. |  [optional] |
|**languages** | **List&lt;String&gt;** | Languages listed on the profile, substring matched. |  [optional] |
|**openToCards** | **List&lt;String&gt;** | LinkedIn open-to cards: CAREER_INTEREST, HIRING_MANAGER, VOLUNTEERING. |  [optional] |
|**profileUpdatedAfter** | **String** | Profile last updated on or after this YYYY-MM-DD date. |  [optional] |
|**headlineContains** | **String** | Substring the profile headline must contain. |  [optional] |
|**summaryContains** | **String** | Substring the profile summary must contain. |  [optional] |
|**twitterHandle** | **String** | Twitter handle, exact; a leading @ is stripped. |  [optional] |
|**titleBooleanQuery** | **String** | Boolean expression over the current title using AND, OR, parentheses and quoted phrases. |  [optional] |
|**keywordsBooleanQuery** | **String** | Boolean expression matched against the headline or summary. |  [optional] |
|**joinedCurrentAfter** | **String** | Started the current role on or after this YYYY-MM-DD date. |  [optional] |
|**pastLeftCompanyAfter** | **String** | Left a past company on or after this YYYY-MM-DD date. |  [optional] |
|**excludeProfileUrls** | **List&lt;String&gt;** | Person LinkedIn URLs to exclude; resolved by the exclusions step. |  [optional] |
|**excludeCompanyDomains** | **List&lt;String&gt;** | Current employer domains to exclude; resolved by the exclusions step. |  [optional] |
|**excludeCrmCustomers** | **Boolean** | Exclude current CRM customers (legacy flat CRM toggle). |  [optional] |
|**excludeCrmActiveOpportunities** | **Boolean** | Exclude CRM accounts with active opportunities (legacy toggle). |  [optional] |
|**excludeCrmOwnedByMe** | **Boolean** | Exclude CRM records owned by the caller (legacy toggle). |  [optional] |
|**excludeCrmOwnedByOthers** | **Boolean** | Exclude CRM records owned by other users (legacy toggle). |  [optional] |
|**excludeCrmOwner** | **String** | CRM user id whose owned records are excluded (legacy field). |  [optional] |
|**excludeCrmAccountStatus** | **String** | CRM account status value to exclude (legacy field). |  [optional] |
|**crmFilterSections** | [**CrmFilterSections**](CrmFilterSections.md) | Per-CRM include/exclude clauses resolved by the exclusions step. |  [optional] |
|**excludeInCleanlist** | [**ExcludeInCleanlistEnum**](#ExcludeInCleanlistEnum) | Cleanlist dedupe scope: off, any list in the org, or specific lists. |  [optional] |
|**excludeInCleanlistListIds** | **List&lt;String&gt;** | Lead list ids the list scope resolves against. |  [optional] |
|**companyFilterCompositeMode** | **Boolean** | Routing override that targets the company-first composite search. |  [optional] |
|**geoRadius** | [**GeoRadius**](GeoRadius.md) |  |  [optional] |
|**maxResults** | **Integer** | Portal result cap. In the public API, explicitly setting this applies a per-response ceiling of 1-500 rows, combined with limit using the smaller value. The default is non-binding; continuation pages are separate. Not a provider filter. |  [optional] |
|**limitPerCompany** | **String** | Portal client-side company cap. In the public API, 1-100 caps each returned page by its selected matching company; unknown-company rows are omitted with a warning. Continuation pages may return more from that company. Empty means unset. |  [optional] |



## Enum: JobTitleMatchTypeEnum

| Name | Value |
|---- | -----|
| CONTAINS | &quot;contains&quot; |
| EXACT | &quot;exact&quot; |
| SIMILAR | &quot;similar&quot; |



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



