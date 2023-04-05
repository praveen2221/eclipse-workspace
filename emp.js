const IS_ABSENT = 0;
/// Generates 0 or 1 randomly.
let empcheck = Math.floor(Math.random() * 10) % 2;
/// Checks Employee is present or not.
if (empcheck == IS_ABSENT) {
    // Prints Employee is absent when random number is 0.
    console.log("Employee is Absent.");
    return;
}
else {
    // Prints Employee is Present when random number is 1.
    console.log("Employee is Present.");
}
// UC 2 Check for daily wage based on whether the employee is part time or full time
const IS_PART_TIME = 1;
const IS_FULL_TIME = 2;
const PART_TIME_HOURS = 4;
const FULL_TIME_HOURS = 8;
const WAGE_PER_HOUR = 20;
const NUM_OF_WORKING_DAYS = 20;
const MAX_WORKING_HOURS = 100;
/// UC3 Checks for the employee type Using Function.
function GetWorkingHours(employeecheck) {
    switch (employeecheck) {
        case IS_PART_TIME:
            return PART_TIME_HOURS;
            break;
        case IS_FULL_TIME:
            return FULL_TIME_HOURS;
            break;
        default:
            return 0;
    }
}
// UC6:- Calculate daily wage
function calcDailyWage(empHrs) {
    return empHrs * WAGE_PER_HOUR;
}
let totalEmpHrs = 0;
let totalWorkingDays = 0;
//employee wage array
let empDailyWageArr = new Array();
//employee wage map
let empDailyWageMap = new Map();
//employee daily hour map
let empDailyHourMap = new Map();
//Array to hold emphrs , daily wage
let empDailyHrsAndWageArr = new Array();
// UC5 Replacing the for loop with the while loop and then evaluating the employee wage
while (totalEmpHrs <= MAX_WORKING_HOURS && totalWorkingDays < NUM_OF_WORKING_DAYS) {
    totalWorkingDays++;
    let employeeCheck = Math.floor(Math.random() * 10) % 3;
    let empHrs = GetWorkingHours(employeeCheck);
    empDailyHrsAndWageArr.push(
        {
            dayNum: totalWorkingDays,
            dailyHours: empHrs,
            dailyWage: calcDailyWage(empHrs),
            toString() {
                return '\nDay' + this.dayNum + '- Working Hour is: ' + this.dailyHours + 'And wage earned: ' + this.dailyWage;
            }
        });
}
/// Calculates Employee wage for a day.
let empWage = totalEmpHrs * WAGE_PER_HOUR;
/// Prints Employee wage.
console.log("UC6 Total Days: " + totalWorkingDays + " Total working hours: " + totalEmpHrs +
    " Employee wage is: " + empWage);
// UC7A Array helper function
let totalempWage = 0;
function sum(dailyWage) {
    totalempWage += dailyWage;
}
empDailyWageArr.forEach(sum)
console.log("UC7A- Total Days: " + totalWorkingDays + " Total Hrs: " + totalEmpHrs + " Emp wage: " + totalempWage);

function totalWages(totalWage, dailyWage) {
    return totalWage + dailyWage;
}
console.log("UC7A - Emp wage with reduce: " + empDailyWageArr.reduce(totalWages, 0));

// UC7B- Show the Day along with daily wage using array map helper Function.
let dailyCounter = 0;
function mapDayWithWage(dailyWage) {
    dailyCounter++;
    return dailyCounter + "=" + dailyWage;
}
let mapDayWithWageArr = empDailyWageArr.map(mapDayWithWage);
console.log("UC7B - Daily Wage Map");
console.log(mapDayWithWageArr);

// UC7C - Shows Days when full time wage of 160 were earned using filter function.
function fullTimeWage(dailyWage) {
    return dailyWage.includes("160");
}
let fullDayWageArr = mapDayWithWageArr.filter(fullTimeWage);
console.log("UC7C- Daily wage filter when fulltime wage earned.");
console.log(fullDayWageArr);

// UC7D - Find the first occurence when full time wage was earned using find function.
function findFullTimeWage(dailyWage) {
    return dailyWage.includes("160");
}
console.log("UC7D - First time full time wage was earned on Day: " + mapDayWithWageArr.find(findFullTimeWage));

// UC7E Check if Every element of full time wage is truelly holding full time wage.
function isAllFullTimeWage(dailyWage) {
    return dailyWage.includes("160");
}
console.log("UC7E - Check all elements have full time wage : " + fullDayWageArr.every(isAllFullTimeWage));

//UC7F Check if there is any part time wage 
function isAnyPartTimeWage(dailyWage) {
    return dailyWage.includes("80");
}
console.log("UC7F Check If Any part time Wage: " + mapDayWithWageArr.some(isAnyPartTimeWage));

//UC7G Find the number of Days the employee worked.
function totalDaysWorked(numOfDays, dailyWage) {
    if (dailyWage > 0) return numOfDays + 1;
    return numOfDays;
}
console.log("UC7G Num of days employee worked: " + empDailyWageArr.reduce(totalDaysWorked, 0));
//UC8 Printing Daily wage stored in Map.
let totalWageFromMap = 0;
for (let empWage of empDailyWageMap.values()) {
    totalWageFromMap += empWage;
}
console.log(empDailyWageMap)
console.log("UC8:-Daily wage from Map: " + totalWageFromMap);
//UC9A  total hours and wage using Arrow Functions
const findTotal = (totalVal, dailyVal) => {
    return totalVal + dailyVal;
}
let totalHours = Array.from(empDailyHourMap.values()).reduce(findTotal, 0);
let totalSalary = empDailyWageArr.filter(dailyWage => dailyWage > 0).reduce(findTotal, 0);
console.log("UC9A:- Emp wage with arrrow. " + "Total Hours: " + totalHours + "TotalWages: " + totalSalary);
//UC9B No of fulltime, parttime and absent days
let nonWorkingDays = new Array();
let partWorkingDays = new Array();
let fullWorkingDays = new Array();
empDailyHourMap.forEach((value, key, map) => {
    if (value == 8) fullWorkingDays.push(key);
    else if (value == 4) partWorkingDays.push(key);
    else nonWorkingDays.push(key);
});
console.log("Full working days: " + fullWorkingDays);
console.log("Part working days: " + partWorkingDays);
console.log("Non working days: " + nonWorkingDays);

// UC10
console.log("UC10 Displays daily hours and wage earned.");
console.log(empDailyHrsAndWageArr.toString());

// UC11A
let totalWage = empDailyHrsAndWageArr.filter(dailyHrsAndWage => dailyHrsAndWage.dailyWage > 0).reduce((totalWage, dailyHrsAndWage) => totalWage = totalWage + dailyHrsAndWage.dailyWage, 0);
let totalHrs = empDailyHrsAndWageArr.filter(dailyHrsAndWage => dailyHrsAndWage.dailyHours > 0).reduce((totalWage, dailyHrsAndWage) => totalWage + dailyHrsAndWage.dailyHours, 0);
console.log("UC11A Total hours: " + totalHrs+ "Total Wage: "+ totalWage);

//UC11B
process.stdout.write("UC11B Displays full work days using foreach loop");
empDailyHrsAndWageArr.filter(dailyHrsAndWage => dailyHrsAndWage.dailyHours == 8)
                     .forEach(dailyHrsAndWage => process.stdout.write(dailyHrsAndWage.toString()))
                
//UC11C
let partWorkDaysStrArr = empDailyHrsAndWageArr.filter(dailyHrsAndWage => dailyHrsAndWage.dailyHours == 4)
                        .map(dailyHrsAndWage => dailyHrsAndWage.toString());
console.log("\nUC11C Part working days: " + partWorkDaysStrArr);

//UC11D
let nonWorkDayNumArr = empDailyHrsAndWageArr.filter(dailyHrsAndWage => dailyHrsAndWage.dailyHours == 0)
                        .map(dailyHrsAndWage => dailyHrsAndWage.dayNum);
console.log("\nUC11D Non work days:-" + nonWorkDayNumArr);