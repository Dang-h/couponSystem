package online.dh.couponsystem;

import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

public class testDependency {

	@Test
	public void testYaml() {

//		注意空格
		String yamlStr = "key: hello yaml";
		Yaml yaml = new Yaml();
		Object loadYaml = yaml.load(yamlStr);
		System.out.println(loadYaml);
		System.out.println(loadYaml.getClass().getSimpleName());

	}
}
