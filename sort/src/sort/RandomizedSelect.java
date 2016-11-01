package sort;  
  
import java.util.Arrays;  
import java.util.Comparator;  
import java.util.Random;  
  
/** 
 *  
 * �ο���--------------------------------------------- 
 * http://blog.csdn.net/chen09/article/details/6531678 
 *  
 * ����ѡ���㷨 �� ��������BFPRT �㷨 ���ƣ�������һ�������������Ѱ�ҵ�KС������ 
 *  
 * �ٶȰٿ��Ͻ�������λ������Ҫ�Լ������壬�����2���㷨����������λ���㷨�� 
 * �ο���http://baike.baidu.com/view/170892.htm 
 *  
 * �ܽ᣺----------------------------------------------- 
 * �����λ��֮��λ���㷨������������δ���򼯺��е�K�������㷨��<br> 
 * ��Ҫ˼�����ҵ������е��м��p����ߵ�������С���м��λ�õ������ұߵı����������Ȼ���ж��ҵ����м���Ƿ����K��<br> 
 *  1������������ҵ���<br> 
 *  2�����С��(k<p),���0-p��Χ�����������˼��������в��� <br> 
 *  3���������(k>p),���p-len��Χ�����������˼��������в��ң�ֻ�ǲ���Ҫ��k�����ˣ�������p-k��������<br> 
 *  
 * ���м���ǿ���ѡ���㷨�ĺ���˼�룬ΪʲôҪ���м�㣿��Ϊ����û�б�Ҫֱ��������ϵ�˳������ô���ģ�<br> 
 * ����û�б�Ҫȥ���������������ֻ��Ҫ֪��ĳ���м�����ߵ�����<br> 
 * С�ڸ��м��λ�õ�������֮�ұߵĶ����ڣ�����ǵݹ���ȥ���ҵ���K�����ֻ��ʱ������.<br> 
 *  
 * ��ʵ���ڲ��ҵ�K�����(С)�������㷨�кö࣬��ֻ�����бȽϺõ�һ�ַ�������һ�ֽϺõı�������ڴ�С��Ҳ������������˶ѵ�ǿ��<br> 
 * �ǵ��и��������ǣ�1�ڸ���������ǰ100�������������ô�С����ɵ�Ч�ʱȽϸ�.<br> 
 * ------------------------------------------------ 
 */  
public class RandomizedSelect {  
      
    private static <T> int partition(T[] a, Comparator<? super T> c, int p, int r) {  
        T t = a[r - 1];  
        int i = p - 1;// �м�㣬С�ķ���i����ߣ���ķ��ұߣ���󷵻ص�i�����м��  
        for (int j = p; j < r - 1; j++) {// ��p��r-2��Ϊʲô��r-2�أ���Ϊ��r-1λ�õ����ѱ���Ϊ�ȽϵĶ�����  
            if (c.compare(a[j], t) <= 0) {// ����߿�ʼ��ѭ��������ߵ��������һ�������бȽ�,��С�ķ�����ߴ�ķ��ұߣ����Ҽ�����λ��  
                i++;  
                swap(a, i, j);  
            }  
        }  
        // ��randomizedPartition���������ǰ���Ԫ�ŵ��������ô�м���ҵ������ǵð���Ԫ�ŵ��м��������ôi+1�������õ����м��  
        swap(a, i + 1, r - 1);  
        return i + 1;  
    }  
  
    private static <T> int randomizedPartition(T[] a, Comparator<? super T> c,  
            int p, int r) {  
        int i = new Random().nextInt(r - p) + p;// ���ѡ���㷨  
        // ���������λ�õ�����Ϊ��Ԫ����ν��Ԫ���Ǳ��ȽϵĶ������Ǽ�����һ�����Ĵ�С����p��r���м䣬������������Ϊ��Ԫ  
        // �����ԪҪ���ŵ�p...r�����λ�ã���������Ҫ�����һ��Ԫ�ؽ���  
        swap(a, i, r - 1);  
        return partition(a, c, p, r);  
    }  
  
    private static <T> void swap(T[] a, int i, int j) {  
        T t = a[i];  
        a[i] = a[j];  
        a[j] = t;  
    }  
  
    private static <T> T randomizedSelect(T[] t,  
            Comparator<? super T> comparator, int p, int r, int i) {  
        if (p == r)// �ҵ���K����  
            return t[p];  
        int q = randomizedPartition(t, comparator, p, r);// �ҵ��м��  
        int k = q - p + 1;// �м��qǰ�����ж��ٸ�����  
        if (i <= k)// �ж��Ƿ��ҵ���i����  
            return randomizedSelect(t, comparator, p, q, i);// �������  
        else  
            return randomizedSelect(t, comparator, q + 1, r, i - k);// �������  
    }  
  
    private static <T> T randomizedSelect(T[] t,  
            Comparator<? super T> comparator, int i) {  
        return randomizedSelect(t, comparator, 0, t.length, i);  
    }  
  
    public static void main(String[] args) {  
        Integer[] ints = new Integer[20];  
        Random ran = new Random();  
        int k = 10;  
        for (int i = 0; i < ints.length; i++) {  
            ints[i] = ran.nextInt(100);  
        }  
        Integer positiong = randomizedSelect(ints, new Comparator<Integer>() {  
            public int compare(Integer o1, Integer o2) {  
                return o1.intValue() - o2.intValue();  
            }  
        }, k);  
        System.out.println("����ѡ���㷨�����,��"+k+"��������ǣ�"+positiong);  
        Arrays.sort(ints);  
        System.out.println("����󣬵�"+k+"��������ǣ�"+ints[k-1]);  
        System.out.println(Arrays.toString(ints));  
    }  
}  