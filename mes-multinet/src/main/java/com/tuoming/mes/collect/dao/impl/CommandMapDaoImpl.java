/*******************************************************************************
 * Copyright (c) 2013.  Pyrlong All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tuoming.mes.collect.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pyrlong.util.StringUtil;
import com.tuoming.mes.collect.dao.CommandMapDao;
import com.tuoming.mes.collect.dpp.dao.impl.AbstractBaseDao;
import com.tuoming.mes.collect.models.CommandMap;


/**
 * @see com.pyrlong.dpp.dao.impl.AbstractBaseDao
 */
@Component("CommandMapDao")
public class CommandMapDaoImpl extends AbstractBaseDao<CommandMap, String> implements CommandMapDao {
    List<CommandMap> commandMapList;

    /**
     * 获取匹配的指令字典配置
     *
     * @param command
     * @return
     */
    @Override
    public CommandMap getMatchedCommandMap(String command, String version) {
        if (commandMapList == null) {
            commandMapList = listAll();
        }
        for (CommandMap cmd : commandMapList) {
            if (StringUtil.isMatch(command, cmd.getCommandFilter()) && cmd.getManufacturers().getId().equals(version) && cmd.getEnabled())
                return cmd;
        }
        return null;
    }
}
