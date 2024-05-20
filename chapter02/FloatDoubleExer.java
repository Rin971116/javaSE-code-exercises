

class FloatDoubleExer {

//絤策1:结ぉ蛾㏄瞯跑秖3.14蛾畖だ琌1.2 / 2.5 / 6 ―蛾縩?

	public static void main(String[] args) {
		
		double pi = 3.14;
		double circle1Radius = 1.2;
		double circle2Radius = 2.5;
		int circle3Radius = 6;//硂娩ㄏノdouble︽
		double circle1Area = pi*circle1Radius*circle1Radius;
		double circle2Area = pi*circle2Radius*circle2Radius;
		double circle3Area = pi*circle3Radius*circle3Radius;
		
		System.out.println("circle1Area = " + circle1Area);
		System.out.println("circle2Area = " + circle2Area);
		System.out.println("circle3Area = " + circle3Area);
		System.out.println(circle3Area);

/*絤策2:锣传地ん放(80)尼ん放地ん放尼ん放虫だ陪ボ赣放
		尼ん放 = (地ん放 - 32) / 1.8
		
		才腹或ゴ? alt + 0176
*/
		
		double f1 = 80;
		double c1 = (f1 - 32) / 1.8;
		System.out.println("地ん放 = " + f1 + "F");
		System.out.println("尼ん放 = " + c1 + "C");
		
	}
}
