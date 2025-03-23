<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
var menus = [{
	"backMenu": [{
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "管理员信息",
			"menuJump": "列表",
			"tableName": "guanliyuan"
		}],
		"menu": "管理员管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "员工信息",
			"menuJump": "列表",
			"tableName": "yuangong"
		}],
		"menu": "员工管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "客户信息",
			"menuJump": "列表",
			"tableName": "kehu"
		}],
		"menu": "客户管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "员工出勤信息",
			"menuJump": "列表",
			"tableName": "yuangongchuqin"
		}],
		"menu": "员工出勤管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "零件分类信息",
			"menuJump": "列表",
			"tableName": "lingjianfenlei"
		}],
		"menu": "零件分类管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "零件设备信息",
			"menuJump": "列表",
			"tableName": "lingjainshebei"
		}],
		"menu": "零件设备管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "维修信息",
			"menuJump": "列表",
			"tableName": "weixiu"
		}],
		"menu": "维修管理"
	}],
	"frontMenu": [],
	"roleName": "vip管理员",
	"tableName": "users"
}, {
	"backMenu": [{
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "员工信息",
			"menuJump": "列表",
			"tableName": "yuangong"
		}],
		"menu": "员工管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "客户信息",
			"menuJump": "列表",
			"tableName": "kehu"
		}],
		"menu": "客户管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "员工出勤信息",
			"menuJump": "列表",
			"tableName": "yuangongchuqin"
		}],
		"menu": "员工出勤管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "零件分类信息",
			"menuJump": "列表",
			"tableName": "lingjianfenlei"
		}],
		"menu": "零件分类管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "零件设备信息",
			"menuJump": "列表",
			"tableName": "lingjainshebei"
		}],
		"menu": "零件设备管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "维修信息",
			"menuJump": "列表",
			"tableName": "weixiu"
		}],
		"menu": "维修管理"
	}],
	"frontMenu": [],
	"roleName": "管理员",
	"tableName": "guanliyuan"
}, {
	"backMenu": [{
		"child": [{
			"buttons": ["修改"],
			"menu": "客户信息",
			"menuJump": "列表",
			"tableName": "kehu"
		}],
		"menu": "客户管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "维修信息",
			"menuJump": "列表",
			"tableName": "weixiu"
		}],
		"menu": "维修管理"
	}],
	"frontMenu": [],
	"roleName": "客户",
	"tableName": "kehu"
}];
var hasMessage = '';
