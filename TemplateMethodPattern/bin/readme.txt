模板方法模式:模板方法定义了一个算法的基本骨架。(基类)实现算法中不会变化的部分，而变化的部分由具体的子类来实现。

java中的实例:实现Comparable接口，并使用Arrays的sort方法来排序。(并不是严格意义上的模板方法)

好处:1.实现了代码的最大化复用
	2.算法只集中于一个地方，便于修改
	3.可扩展性好

软件设计原则:好莱坞原则，别调用我们，我们会调用你。(防止环状依赖。高层组件决定什么时候、怎么使用底层组件。)



abstract class AbstractClass{
	public final void templateMethod(){
		abstractMethod();
		abstractMethod2();
		concreteOpreation();
	}
	
	abstract void abstractMethod();
	
	abstract void abstractMethod2();
	
	public final void concreteOpreation(){
	
	};
	
	//钩子方法。可以决定子类是否执行算法中的一些步骤;改变抽象类的决定;对模板方法中的一些步骤做出反应等。
	//子类可以选择是否覆盖这个方法。
	public void hook(){
	
	}
}