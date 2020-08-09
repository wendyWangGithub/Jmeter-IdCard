package addition;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class OutPutIdCard extends AbstractJavaSamplerClient {

	private String result;
	
	public Arguments getDefaultParameters() {
		
		Arguments params = new Arguments();
		return params;
	}
	
	public void setupTest(JavaSamplerContext arg0) {
		
	}
	
	public SampleResult runTest(JavaSamplerContext arg0) {

		SampleResult sr = new SampleResult();
		sr.setSampleLabel("生成身份证号");
		try {
			sr.sampleStart();
			IdCardGenerator idCardGenerator = new IdCardGenerator();
			result = idCardGenerator.generate();
			if (result != null) {
				sr.setResponseData("结果是：" + result, null);
				sr.setDataType(SampleResult.TEXT);
				}
				sr.setSuccessful(true);
			} catch (Throwable e) {
				sr.setSuccessful(false);
				e.printStackTrace();
			} finally {
				sr.sampleEnd();
			}
			return sr;
		}
	
	public void teardownTest(JavaSamplerContext arg0) {
		
	}

	// main只是为了调试用，最后打jar包的时候注释掉。

     /* public static void main(String[] args)
      {

      }
*/
	
}
	


