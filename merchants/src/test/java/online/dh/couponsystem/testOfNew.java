package online.dh.couponsystem;

import org.aspectj.apache.bcel.classfile.InnerClass;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import java.util.concurrent.CountDownLatch;

class testOfNew {

	@Test
	void testYaml() {

		// 注意空格
		String yamlStr = "key: hello yaml";
		Yaml yaml = new Yaml();
		Object loadYaml = yaml.load(yamlStr);
		System.out.println(loadYaml);
		System.out.println(loadYaml.getClass().getSimpleName());

	}

	@Test
	void testThreadLocal() throws InterruptedException {
		int threads = 3;
		CountDownLatch countDownLatch = new CountDownLatch(threads);
		InnerClass innerClass = new InnerClass();

		for (int i = 1; i <= threads; i++) {
			new Thread(() -> {
				for (int j = 0; j < 4; j++) {
					innerClass.add(String.valueOf(j));
					innerClass.print();
				}
				innerClass.set("HelloWorld");
				countDownLatch.countDown();
			}, "thread - " + i).start();
		}

		countDownLatch.await();

	}

	private static class InnerClass {

		void add(String newStr) {
			StringBuilder str = Counter.counter.get();
			Counter.counter.set(str.append(newStr));
		}

		void print() {
			System.out.printf("Thread name:%s, ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
					Thread.currentThread().getName(),
					Counter.counter.hashCode(),
					Counter.counter.get().hashCode(),
					Counter.counter.get().toString());
		}

		void set(String words) {
			Counter.counter.set(new StringBuilder(words));
			System.out.printf("Set, Thread name:%s, ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s",
					Thread.currentThread().getName(),
					Counter.counter.hashCode(),
					Counter.counter.get().hashCode(),
					Counter.counter.get().toString());
		}
	}

	private static class Counter {

		private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>() {

			@Override
			protected StringBuilder initialValue() {
				return new StringBuilder();
			}
		};
	}
}
