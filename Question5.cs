using System;
using System.Collections.Generic;
using System.Text;

namespace CsharpQuestions
{
    class Question5
    {
        //IPV4 Validation [HARD]
        //Ex- (1.2.3.4) == Valid     (1.2.3.4.5) == False     (123.45.67.89) == Valid

        //Solution
        public static bool IsValidIP(string IP)
        {
            string[] nums = IP.Split('.');

            if (nums.Length != 4)
                return false;


            string digits = "0123456789";

            for (int i = 0; i < nums.Length; i++)
            {
                for (int j = 0; j < nums[i].Length; j++)
                {

                    //first digit
                    if (i != 0 && j == 0 && nums[i][j] == '0')
                        return false;

                    //last digit
                    if (i == 3 && j == nums[i].Length - 1 && nums[i][j] == '0')
                        return false;


                    if (!digits.Contains(nums[i][j].ToString()))
                        return false;

                }


            }

            return true;


        }
    }
}
