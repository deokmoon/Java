package com.gs;

public class ThirdQuery {
    /*
    *
    *
    *
-- 총금액: 5,779,677,874
SELECT CATEGORY, SUM(SUM_AMT) AMT
FROM (
    SELECT
        CASE
            WHEN PRD_GROUP = "Trend_clothing" OR  PRD_GROUP = "Sports_clothing" OR PRD_GROUP = "Underwear" THEN '의류'
            WHEN PRD_GROUP = "General_food" OR  PRD_GROUP = "Health_food" THEN '식품'
            WHEN PRD_GROUP = "Appliances" OR  PRD_GROUP = "Household_goods" OR PRD_GROUP = "Kitchen_tools" THEN '리빙'
            WHEN PRD_GROUP = "Cosmetics" OR  PRD_GROUP = "hair" THEN '뷰티'
        END CATEGORY
        , SUM(ORD_AMT) SUM_AMT
    FROM GS_ORDER_TBL
    GROUP BY PRD_GROUP
) A
GROUP BY CATEGORY
ORDER BY CATEGORY
;
    *
    * */
}
