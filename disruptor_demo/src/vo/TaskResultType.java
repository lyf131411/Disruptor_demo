package vo;
/**
 * 
 * @author lanyi
 *说明：方法本身运行是否正确的结果类型
 */
public enum TaskResultType {
	//方法成功执行并返回了业务人员需要的结果
	Success,
	//方法执行成功但没有返回业务人员需要的结果
	Failure,
	//方法抛出了异常
	Exception;
}
