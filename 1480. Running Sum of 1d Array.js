var runningSum = function(nums) {
  //this line checks to make sure we're not working with an empty array and returns if nums is empty
    if(nums.length==0) return [];
  //we then create an array to hold our output. I called mine sumArray
    const sumArray = [];
  //We start by getting the first item in our array since we're sure the array is not empty. 
    let currentSum = nums[0];
  //The first item will always remain the same for all solutions so we add it as the first item of our output array sumArray
    sumArray.push(currentSum)
  //We loop through the remaining array (starting at index 1), storing the sums in the currentSum variable 
  //and adding it to the sumArray
    for(let i = 1; i<nums.length; i++){
        currentSum+=nums[i]
        sumArray.push(currentSum)
    }
  //Finally, we return sumArray.
    return sumArray;
};
