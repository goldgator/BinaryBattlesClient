using System;
using NUnit.Framework;

[TestFixture]
public class Tests
{
	
	//Test Question 1
	[Test]
	[TestCase(6, ExpectedResult = 360)]
	[TestCase(4, ExpectedResult = 240)]
	[TestCase(8, ExpectedResult = 480)]
	[TestCase(60, ExpectedResult = 3600)]
	public static int MinuteTest(int a)
	{
		Console.WriteLine($"Input: {a}");
		return CsharpQuestions.Question1.converts(a);
	}
	//Test Question 2

	[Test]
	[TestCase(new int[] { 1, 2, 3, 4 }, ExpectedResult = new int[] { 4, 3, 2, 1 })]
	[TestCase(new int[] { 5, 6, 7 }, ExpectedResult = new int[] { 7, 6, 5 })]
	[TestCase(new int[] { 9, 9, 2, 3, 4 }, ExpectedResult = new int[] { 4, 3, 2, 9, 9 })]
	[TestCase(new int[] { 3, 3 }, ExpectedResult = new[] { 3, 3 })]
	[TestCase(new int[] { -1, -1, -1 }, ExpectedResult = new int[] { -1, -1, -1 })]
	[TestCase(new int[] { }, ExpectedResult = new int[] { })]
	public static int[] ReverseTest(int[] arr)
	{
		Console.WriteLine($"Input: {arr.ToString()}");
		return CsharpQuestions.Question2.Reverse(arr);
	}

	//Test 3
	[Test]
	public void CapitilizeTest()
	{
		string[] haystack_1 = new string[] { "danny", "gali", "jesse" };
		string[] haystack_2 = new string[] { "danny", "GALI", "jeSSe", };


		Assert.AreEqual(new string[] { "Danny", "Gali", "Jesse" }, CsharpQuestions.Question3.Caps(haystack_1));
		Assert.AreEqual(new string[] { "Danny", "Gali", "Jesse", }, CsharpQuestions.Question3.Caps(haystack_2));
	}

		//Test 4
		[Test]
		[TestCase("@Danny.com", ExpectedResult = false)]
		[TestCase("@Danny", ExpectedResult = false)]
		[TestCase("Danny@edabit.com", ExpectedResult = true)]
		[TestCase("", ExpectedResult = false)]
		[TestCase("hello.gmail@com", ExpectedResult = false)]
		[TestCase("danny.gates@microsoft.com", ExpectedResult = true)]
		public static bool EmailTest(string str)
		{
		return CsharpQuestions.Question4.ValidateEmail(str);
	}

	//Test 5
	[Test]
	[TestCase("12.255.56.1", ExpectedResult = true)]
	[TestCase("1.2.3.4", ExpectedResult = true)]
	[TestCase("", ExpectedResult = false)]
	[TestCase("abc.def.ghi.jkl", ExpectedResult = false)]
	[TestCase("0.232.47.227", ExpectedResult = true)]
	[TestCase("1e0.1e0.1e0.1e0", ExpectedResult = false)]
	public static bool IPTest(string IP)
	{
		return CsharpQuestions.Question5.IsValidIP(IP);
	}
}



