(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7a0bc8dc"],{"06bd":function(t,i,s){},"16fc":function(t,i,s){"use strict";s.r(i);var e=function(){var t=this,i=t.$createElement,s=t._self._c||i;return s("div",{staticClass:"components-container"},[t._m(0),s("div",{staticClass:"editor-container"},[s("dnd-list",{attrs:{list1:t.list1,list2:t.list2,"list1-title":"List","list2-title":"Article pool"}})],1)])},a=[function(){var t=this,i=t.$createElement,s=t._self._c||i;return s("aside",[t._v("drag-list base on "),s("a",{attrs:{href:"https://github.com/SortableJS/Vue.Draggable",target:"_blank"}},[t._v("Vue.Draggable")])])}],l=(s("a434"),function(){var t=this,i=t.$createElement,s=t._self._c||i;return s("div",{staticClass:"dndList"},[s("div",{staticClass:"dndList-list",style:{width:t.width1}},[s("h3",[t._v(t._s(t.list1Title))]),s("draggable",{staticClass:"dragArea",attrs:{"set-data":t.setData,list:t.list1,group:"article"}},t._l(t.list1,(function(i){return s("div",{key:i.id,staticClass:"list-complete-item"},[s("div",{staticClass:"list-complete-item-handle"},[t._v(" "+t._s(i.id)+"["+t._s(i.author)+"] "+t._s(i.title)+" ")]),s("div",{staticStyle:{position:"absolute",right:"0px"}},[s("span",{staticStyle:{float:"right","margin-top":"-20px","margin-right":"5px"},on:{click:function(s){return t.deleteEle(i)}}},[s("i",{staticClass:"el-icon-delete",staticStyle:{color:"#ff4949"}})])])])})),0)],1),s("div",{staticClass:"dndList-list",style:{width:t.width2}},[s("h3",[t._v(t._s(t.list2Title))]),s("draggable",{staticClass:"dragArea",attrs:{list:t.list2,group:"article"}},t._l(t.list2,(function(i){return s("div",{key:i.id,staticClass:"list-complete-item"},[s("div",{staticClass:"list-complete-item-handle2",on:{click:function(s){return t.pushEle(i)}}},[t._v(" "+t._s(i.id)+" ["+t._s(i.author)+"] "+t._s(i.title)+" ")])])})),0)],1)])}),n=[],r=s("b85c"),c=(s("d3b7"),s("1980")),d=s.n(c),o={name:"DndList",components:{draggable:d.a},props:{list1:{type:Array,default:function(){return[]}},list2:{type:Array,default:function(){return[]}},list1Title:{type:String,default:"list1"},list2Title:{type:String,default:"list2"},width1:{type:String,default:"48%"},width2:{type:String,default:"48%"}},methods:{isNotInList1:function(t){return this.list1.every((function(i){return t.id!==i.id}))},isNotInList2:function(t){return this.list2.every((function(i){return t.id!==i.id}))},deleteEle:function(t){var i,s=Object(r["a"])(this.list1);try{for(s.s();!(i=s.n()).done;){var e=i.value;if(e.id===t.id){var a=this.list1.indexOf(e);this.list1.splice(a,1);break}}}catch(l){s.e(l)}finally{s.f()}this.isNotInList2(t)&&this.list2.unshift(t)},pushEle:function(t){var i,s=Object(r["a"])(this.list2);try{for(s.s();!(i=s.n()).done;){var e=i.value;if(e.id===t.id){var a=this.list2.indexOf(e);this.list2.splice(a,1);break}}}catch(l){s.e(l)}finally{s.f()}this.isNotInList1(t)&&this.list1.push(t)},setData:function(t){t.setData("Text","")}}},u=o,f=(s("4cf8"),s("2877")),h=Object(f["a"])(u,l,n,!1,null,"005c1ad2",null),p=h.exports,v=s("2423"),g={name:"DndListDemo",components:{DndList:p},data:function(){return{list1:[],list2:[]}},created:function(){this.getData()},methods:{getData:function(){var t=this;this.listLoading=!0,Object(v["a"])().then((function(i){t.list1=i.data.items.splice(0,5),t.list2=i.data.items}))}}},m=g,b=Object(f["a"])(m,e,a,!1,null,null,null);i["default"]=b.exports},2423:function(t,i,s){"use strict";s.d(i,"a",(function(){return a}));var e=s("b775");function a(t){return Object(e["a"])({url:"/vue-element-admin/article/list",method:"get",params:t})}},"4cf8":function(t,i,s){"use strict";s("06bd")}}]);