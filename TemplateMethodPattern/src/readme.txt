ģ�巽��ģʽ:ģ�巽��������һ���㷨�Ļ����Ǽܡ�(����)ʵ���㷨�в���仯�Ĳ��֣����仯�Ĳ����ɾ����������ʵ�֡�

java�е�ʵ��:ʵ��Comparable�ӿڣ���ʹ��Arrays��sort����������(�������ϸ������ϵ�ģ�巽��)

�ô�:1.ʵ���˴������󻯸���
	2.�㷨ֻ������һ���ط��������޸�
	3.����չ�Ժ�

������ԭ��:������ԭ�򣬱�������ǣ����ǻ�����㡣(��ֹ��״�������߲��������ʲôʱ����ôʹ�õײ������)



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
	
	//���ӷ��������Ծ��������Ƿ�ִ���㷨�е�һЩ����;�ı������ľ���;��ģ�巽���е�һЩ����������Ӧ�ȡ�
	//�������ѡ���Ƿ񸲸����������
	public void hook(){
	
	}
}