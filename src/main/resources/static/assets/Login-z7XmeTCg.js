import{_ as U,g as f,c as x,a as u,n as b,d as l,w as o,h as z,r as v,o as R,e as V,i as c,E as d}from"./index-ChpFSsXe.js";const B={class:"container"},E={__name:"Login",setup(I){const p=f(!1),n=f(""),t=f(""),w=f(""),g=()=>{p.value=!0},y=()=>{p.value=!1},k=async()=>{try{(await c.post("/api/users/login",null,{params:{name:n.value,password:t.value}})).data?d.success("登录成功"):d.error("用户名或密码错误")}catch(s){d.error("登录请求失败，请稍后再试"),console.error(s)}},C=async()=>{try{(await c.post("/api/users/updata",{name:n.value,email:w.value,password:t.value})).data?(d.success("注册成功"),y()):d.error("注册失败，请检查输入")}catch(s){d.error("注册请求失败，请稍后再试"),console.error(s)}};return(s,e)=>{const m=v("el-input"),a=v("el-form-item"),i=v("el-button"),_=v("el-form");return R(),x("div",B,[u("div",{class:z(["flip-container",{flipped:p.value}])},[u("div",{class:"front",style:b({zIndex:p.value?1:2})},[l(_,{model:s.form,rules:s.rules,ref:"formRef"},{default:o(()=>[e[7]||(e[7]=u("h1",null,"登录",-1)),e[8]||(e[8]=u("br",null,null,-1)),l(a,{label:"用户名",prop:"username"},{default:o(()=>[l(m,{modelValue:n.value,"onUpdate:modelValue":e[0]||(e[0]=r=>n.value=r),placeholder:"请输入用户名"},null,8,["modelValue"])]),_:1}),l(a,{label:"密码",prop:"password"},{default:o(()=>[l(m,{type:"password",modelValue:t.value,"onUpdate:modelValue":e[1]||(e[1]=r=>t.value=r),placeholder:"请输入密码"},null,8,["modelValue"])]),_:1}),l(a,null,{default:o(()=>[l(i,{type:"primary",onClick:k},{default:o(()=>e[5]||(e[5]=[V("登录")])),_:1})]),_:1}),l(a,null,{default:o(()=>[l(i,{onClick:g},{default:o(()=>e[6]||(e[6]=[V("去注册")])),_:1})]),_:1})]),_:1},8,["model","rules"])],4),u("div",{class:"back",style:b({zIndex:p.value?2:1})},[l(_,{model:s.form,rules:s.rules,ref:"formRef"},{default:o(()=>[e[11]||(e[11]=u("h1",null,"注册",-1)),e[12]||(e[12]=u("br",null,null,-1)),l(a,{label:"用户名",prop:"username"},{default:o(()=>[l(m,{modelValue:n.value,"onUpdate:modelValue":e[2]||(e[2]=r=>n.value=r),placeholder:"请输入用户名"},null,8,["modelValue"])]),_:1}),l(a,{label:"邮箱",prop:"email"},{default:o(()=>[l(m,{modelValue:w.value,"onUpdate:modelValue":e[3]||(e[3]=r=>w.value=r),placeholder:"请输入邮箱"},null,8,["modelValue"])]),_:1}),l(a,{label:"密码",prop:"password"},{default:o(()=>[l(m,{type:"password",modelValue:t.value,"onUpdate:modelValue":e[4]||(e[4]=r=>t.value=r),placeholder:"请输入密码"},null,8,["modelValue"])]),_:1}),l(a,null,{default:o(()=>[l(i,{type:"primary",onClick:C},{default:o(()=>e[9]||(e[9]=[V("注册")])),_:1})]),_:1}),l(a,null,{default:o(()=>[l(i,{onClick:y},{default:o(()=>e[10]||(e[10]=[V("返回登录")])),_:1})]),_:1})]),_:1},8,["model","rules"])],4)],2)])}}},N=U(E,[["__scopeId","data-v-7c08cab1"]]);export{N as default};
