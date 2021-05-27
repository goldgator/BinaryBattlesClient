using System;
using System.Collections.Generic;
using System.Text;

namespace CsharpQuestions
{
    public class Question3
    {
        //Make a Function That takes in an Array of names and Changes the first letter to capital.[MEDIUM]
        //Ex - [danny, shakur, sawyer] --> [Danny, Shakur, Sawyer]

        //Solutuion
        public static string[] Caps(string[] arr)
        {
            for (int i = 0; i < arr.Length; i++)
            {
                arr[i] = arr[i].Substring(0, 1).ToUpper() +
                    arr[i].Substring(1).ToLower();
            }

            return arr;
        }
    }
}

