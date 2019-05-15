package demo;

import java.util.Random;

import tools.SleepTools;
import vo.ITaskProcesser;
import vo.TaskResult;
import vo.TaskResultType;

/**
 * 
 * @author lanyi
 *说明：一个实际的任务类，在数值上加一个随机数，并休眠随机时间
 */
public class Mytask implements ITaskProcesser<Integer,Integer> {

	@Override
	public TaskResult<Integer> taskExecute(Integer data) {
		Random r = new Random();
		int flag = r.nextInt(800);
		SleepTools.ms(flag);
		if(flag<=500) {//正常处理的情况
			Integer returnValue = data.intValue()+flag;
			return new TaskResult<Integer>(TaskResultType.Success,returnValue);
		}else if(flag>501&&flag<=650) {//处理失败的情况
			return new TaskResult<Integer>(TaskResultType.Failure,-1,"Failure");
		}else {//发生异常的情况
			try {
				throw new RuntimeException("异常发生了！！");
			} catch (Exception e) {
				return new TaskResult<Integer>(TaskResultType.Exception,
						-1,e.getMessage());
			}
		}
	}
	
}
