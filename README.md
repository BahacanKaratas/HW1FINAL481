MY PROJECT:

-There is a team of construction workers and they need various sizes of a triangle shaped concrete.This team
has some straight line shaped concretes that they can use to build the triangle needed.

Problems:

-But there is a problem, they need to calculate from any 3 straight line shaped concrete(3 sides) if a triangle can be formed using them.
-Another problem they have is that they need this triangle large enough to satisfy the needs. So they hand in
a list of triangle circumfrences and if the circumfrence ot the triangle formed prior is larger than ALL of them , it will satisfy their needs.

Extra: This is not a problem to them but they are also curious to know if this triangle is isosceles,scalene or equaliteral triangle.

Solution:
-My program , when given 3 side parameters and 1 circumfrence arraylist provides ;
    -if a triangle can be made with them using mathematical formula for a triangle to be formed.
        -if a triangle can be formed, is it large enough to satisfy their needs.
            -if both true than my program signals true 
            *extra info: (can be seen in heroku log --tail) is isosceles,scalene or equaliteral triangle

    -if a triangle cannot be formed or if a triangle can be formed but is not large enough it signals false
        *(if a triangle can be formed)extra info: (can be seen in heroku log --tail) is isosceles,scalene or equaliteral triangle

TESTS EXPLANATION:
-There are total 9 tests (5 of them is necessary due to hw Specifications (covering corner cases).)

    1: checks if any side length is <=0 since this is impossible (returns false)

    2: checks if an empty arraylist has given since this will be an error (returns false)

    (3-8): checks when a triangle is formed, what type it is and if it is large enough.
        *since the type of triangle does not change the outcome, we can assume 2 tests are here,therefore we now have total 4 necessary tests.
            3: a triangle can be made and large enough (returns true)
            4: a triangle can be made and not large enough (returns false)

    9/5:checks if a triangle cannot be formed (returns false)

[![Build Status](https://app.travis-ci.com/BahacanKaratas/HW1FINAL481.svg?branch=main)](https://app.travis-ci.com/BahacanKaratas/HW1FINAL481)

https://nameless-escarpment-76420.herokuapp.com/compute