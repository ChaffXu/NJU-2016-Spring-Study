import static org.junit.Assert.*;

import org.junit.Test;


public class ArrayPartitionTest {

	private ArrayPartition ap;
	@Test
	public void test() {
		int[] a1 = new int[]{1};
		int[] a2 = new int[]{4,2,5,7,1,3,9};
		ap = new ArrayPartition(a1);
		ap.partition();
		assertTrue(ap.isWeaklySorted());
		
		ap = new ArrayPartition(a2);
		ap.partition();
		assertTrue(ap.isWeaklySorted());
		//��xxx &&xxx����һ��Ӧ�ö�����1/4���ǲ����ɣ�����Ϊʲô����������ͨ�����أ�������˵Ӧ�÷���false����
	}

}
