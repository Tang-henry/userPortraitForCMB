package com.fid.service.business.userLaber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fid.dto.helper.SetBatchUserHaveStockHelperDto;
import com.fid.model.business.userLaber.EveryDayHaveStock;
import com.fid.model.common.DbConfig;
import com.fid.service.IService;
import com.fid.vo.common.MsgMap;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
public interface EveryDayHaveStockService extends IService<EveryDayHaveStock> {

	MsgMap setBatchUserHaveStock(SetBatchUserHaveStockHelperDto dto);

}
