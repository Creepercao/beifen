import{_ as C,g as m,c as U,a as s,n as g,d as e,w as o,h as c,r as f,o as z,e as v,i as y}from"./index-CXPkgwzE.js";const B={class:"container"},I={__name:"Login",setup(L){const p=m(!1),u=m(""),r=m(""),V=m(""),b=()=>{p.value=!0},w=()=>{p.value=!1},x=async()=>{try{const n=await y.post("/api/auth/login",{username:u.value,password:r.value});console.log("登录成功",n.data)}catch(n){console.error("登录失败",n)}},k=async()=>{try{const n=await y.post("/api/auth/register",{username:u.value,password:r.value,email:V.value});console.log("注册成功",n.data)}catch(n){console.error("注册失败",n)}};return(n,l)=>{const d=f("el-input"),a=f("el-form-item"),i=f("el-button"),_=f("el-form");return z(),U("div",B,[s("div",{class:c(["flip-container",{flipped:p.value}])},[s("div",{class:"front",style:g({zIndex:p.value?1:2})},[e(_,null,{default:o(()=>[l[8]||(l[8]=s("h1",null,"登录",-1)),l[9]||(l[9]=s("br",null,null,-1)),e(a,{label:"用户名"},{default:o(()=>[e(d,{modelValue:u.value,"onUpdate:modelValue":l[0]||(l[0]=t=>u.value=t),placeholder:"请输入用户名"},null,8,["modelValue"])]),_:1}),e(a,{label:"密码"},{default:o(()=>[e(d,{type:"password",modelValue:r.value,"onUpdate:modelValue":l[1]||(l[1]=t=>r.value=t),placeholder:"请输入密码"},null,8,["modelValue"])]),_:1}),e(a,{label:"验证码"},{default:o(()=>[e(d),l[5]||(l[5]=s("img",null,null,-1))]),_:1}),e(a,null,{default:o(()=>[e(i,{type:"primary",onClick:x},{default:o(()=>l[6]||(l[6]=[v("登录")])),_:1})]),_:1}),e(a,null,{default:o(()=>[e(i,{onClick:b},{default:o(()=>l[7]||(l[7]=[v("去注册")])),_:1})]),_:1})]),_:1})],4),s("div",{class:"back",style:g({zIndex:p.value?2:1})},[e(_,null,{default:o(()=>[l[12]||(l[12]=s("h1",null,"注册",-1)),l[13]||(l[13]=s("br",null,null,-1)),e(a,{label:"用户名"},{default:o(()=>[e(d,{modelValue:u.value,"onUpdate:modelValue":l[2]||(l[2]=t=>u.value=t),placeholder:"请输入用户名"},null,8,["modelValue"])]),_:1}),e(a,{label:"邮箱"},{default:o(()=>[e(d,{modelValue:V.value,"onUpdate:modelValue":l[3]||(l[3]=t=>V.value=t),placeholder:"请输入邮箱"},null,8,["modelValue"])]),_:1}),e(a,{label:"密码"},{default:o(()=>[e(d,{type:"password",modelValue:r.value,"onUpdate:modelValue":l[4]||(l[4]=t=>r.value=t),placeholder:"请输入密码"},null,8,["modelValue"])]),_:1}),e(a,null,{default:o(()=>[e(i,{type:"primary",onClick:k},{default:o(()=>l[10]||(l[10]=[v("注册")])),_:1})]),_:1}),e(a,null,{default:o(()=>[e(i,{onClick:w},{default:o(()=>l[11]||(l[11]=[v("返回登录")])),_:1})]),_:1})]),_:1})],4)],2)])}}},R=C(I,[["__scopeId","data-v-d3d328bf"]]);export{R as default};
