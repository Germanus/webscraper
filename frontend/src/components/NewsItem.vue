<template>
  <div class="hello">
    <ul>
      <li v-for="article in articles" :key="article.title" style="padding-bottom: 20px">
        <em class="pi pi-times"  style="margin: 0 10px 0 0px" v-on:click="removeArticle(article.id)"/>      
        <span style="word-wrap: normal">{{article.title}}</span>         
        <a v-bind:href="article.href" style="margin-left:5px; color: #b94252" target="_blank">Читать</a>                 
      </li>
    </ul>
  </div>
</template>

<script>

import axios from "axios";
import "primevue/resources/themes/nova-vue/theme.css";
import "primevue/resources/primevue.min.css";
import "primeicons/primeicons.css";

export default {
  name: "NewsItem",
  data() {
    return {
      msg: "HowTo call REST-Services:",
      articles: [],
      errors: []
    };
  },
  mounted() {
    axios.get("/habr/articles").then(response => (this.articles = response.data));
  },
  methods: {
    removeArticle(id){
      this.articles = this.articles.filter(a => a.id != id);
      console.log(id);
      // var index = this.articles.indexOf(event.article);
      // if(index != -1){
      //   console.log(this.articles.splice(index, 1)[0].title);
      // }
      axios.delete("/habr/articles/" + id).then(()=> this.getArticles());
    },
    getArticles(){
      axios.get("/habr/articles").then(response => (this.articles = response.data));
    }
  }
};
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.p-button{
  color:black;
}
.accordion-custom {
  i,
  span {
    vertical-align: middle;
  }

  span {
    margin: 0 0.5rem;
  }
}
</style>
