using System;
using System.Collections.Generic;
using System.Text;

namespace CsharpQuestions
{
    class Question4
    {
        //Email Validation! [Medium]
        //String must have "@", "." , 
        //@ must have 1 charater in front of it "MasterGuy@"
        // Ex - "@Masterguy.gmail.com" = Invalid        "MasterGuy@Gmail.com" = Valid

        //Solution
        public static bool ValidateEmail(string str)
        {
            int last_dot = 0;
            int a = 0;

            for (int i = 0; i < str.Length; i++)
            {
                if (str[i] == '.')
                {
                    last_dot = i;
                }
                if (str[i] == '@')
                {
                    a = i;
                }
            }
            if (last_dot > a && a > 0)
            {
                return true;
            }
            else return false;
        }
    }

}

