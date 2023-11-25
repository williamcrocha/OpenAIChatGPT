# Getting Started

This is a simple example how to integrate Spring Boot to ChatGPT. Uses the last public version that is ChatGPT 3.5 turbo.

### Reference Documentation

* [ChatGPT API reference](https://platform.openai.com/docs/api-reference/chat/create)
 
### Configuration

* Inform [your API key](https://platform.openai.com/docs/api-reference/chat/create) in application.yml
* Read [Q & A](#qa) before running

### Running

Just run OpenAiChatGptApplication.

### How to use

You can use your browse or the [docs page](http://localhost:8080/swagger-ui/index.html) to make the requests

### Q & A<a name="qa"></a>

**Q:** When you receive the error "429 Too Many Requests"

**A:** You need to upgrade to a paid plan. Set up a paid account, add a credit or debit card, and generate a new API key if your old one was generated before the upgrade. It might take 10 minutes or so after you upgrade to a paid plan before the paid account becomes active and the error disappears.