import{_ as D,g as p,c as i,a as t,v as e,d as c,w as v,F as C,s as V,r as y,o,e as d,t as w,y as x,x as H}from"./index-BMl4G-EU.js";const K={class:"article-container"},M={class:"article-title"},R={class:"author-info"},E={class:"author-details"},I={class:"author-name"},U={class:"publish-time"},$={class:"comment-count"},j=["innerHTML"],A={class:"tags-container"},P={class:"comments-section"},q={class:"comment-content"},G={class:"comment-time"},J={class:"maincontent"},O={key:0,class:"replies"},Q={class:"reply-content"},W={class:"comment-time"},X={class:"maincontent"},Y={__name:"Show",setup(Z){const s=p({title:"示例文章标题",author:{name:"作者名",avatar:"https://via.placeholder.com/50"},publishTime:"2024-12-25 15:30",tags:["Vue.js","Element Plus","开发"],likes:42,content:`
    <p>这是文章的第一段内容。</p>
    <p>这是文章的第二段内容，展示了如何使用 <strong>HTML</strong> 标签。</p>
    <p>这是最后一段内容。</p>
  `,comments:[{author:"评论者1",avatar:"https://via.placeholder.com/40",content:"这是一条示例评论。",time:"2024-12-25 16:00",replies:[{author:"回复者1",avatar:"https://via.placeholder.com/30",content:"这是对评论的回复。",time:"2024-12-25 16:05"}]}]}),g=p(!1),u=p(""),k=p(null),m=p(""),L=()=>{s.value.likes++},T=()=>{g.value=!g.value},S=()=>{u.value.trim()!==""&&(s.value.comments.push({author:"新用户",avatar:"https://via.placeholder.com/40",content:u.value,time:new Date().toLocaleString(),replies:[]}),u.value="")},z=_=>{k.value=_},B=_=>{m.value.trim()!==""&&(s.value.comments[_].replies.push({author:"新回复者",avatar:"https://via.placeholder.com/30",content:m.value,time:new Date().toLocaleString()}),m.value="",k.value=null)};return(_,a)=>{const f=y("el-avatar"),h=y("el-button"),F=y("el-tag"),b=y("el-input");return o(),i("div",K,[t("h1",M,e(s.value.title),1),t("div",R,[c(f,{src:s.value.author.avatar,size:"medium"},null,8,["src"]),t("div",E,[t("span",I,e(s.value.author.name),1),t("span",U,e(s.value.publishTime),1),t("span",$,"💬 "+e(s.value.comments.length)+" 条评论",1),c(h,{type:"text",onClick:L},{default:v(()=>[d(" 👍 点赞 "+e(s.value.likes),1)]),_:1}),c(h,{type:"text",onClick:T},{default:v(()=>[d(e(g.value?"⭐ 已收藏":"⭐ 收藏"),1)]),_:1})])]),t("div",{class:"article-content",innerHTML:s.value.content},null,8,j),t("div",A,[(o(!0),i(C,null,V(s.value.tags,(l,r)=>(o(),w(F,{key:r,type:"success"},{default:v(()=>[d(e(l),1)]),_:2},1024))),128))]),t("div",P,[a[4]||(a[4]=t("h2",{class:"comments-title"},"评论",-1)),c(b,{modelValue:u.value,"onUpdate:modelValue":a[0]||(a[0]=l=>u.value=l),placeholder:"写下你的评论...",type:"textarea",rows:3},null,8,["modelValue"]),c(h,{type:"primary",class:"submit-comment",onClick:S},{default:v(()=>a[2]||(a[2]=[d(" 发布评论 ")])),_:1}),(o(!0),i(C,null,V(s.value.comments,(l,r)=>(o(),i("div",{key:r,class:"comment-item"},[c(f,{src:l.avatar,size:"small"},null,8,["src"]),t("div",q,[t("p",null,[t("strong",null,e(l.author),1),t("span",G,e(l.time),1)]),t("p",J,e(l.content),1),l.replies?(o(),i("div",O,[(o(!0),i(C,null,V(l.replies,(n,N)=>(o(),i("div",{key:N,class:"reply-item"},[c(f,{src:n.avatar,size:"small"},null,8,["src"]),t("div",Q,[t("p",null,[t("strong",null,e(n.author),1),t("span",W,e(n.time),1)]),t("p",X,e(n.content),1)])]))),128))])):x("",!0),c(h,{type:"text",class:"reply-button",onClick:n=>z(r)},{default:v(()=>a[3]||(a[3]=[d(" 回复 ")])),_:2},1032,["onClick"]),k.value===r?(o(),w(b,{key:1,modelValue:m.value,"onUpdate:modelValue":a[1]||(a[1]=n=>m.value=n),placeholder:"回复评论...",size:"small",onKeyup:H(n=>B(r),["enter","native"])},null,8,["modelValue","onKeyup"])):x("",!0)])]))),128))])])}}},et=D(Y,[["__scopeId","data-v-948f67a7"]]);export{et as default};
