# springboot-test

A minimal Spring Boot REST API that answers the question **"你是什么大模型？"** (What large language model are you?).

## Endpoint

| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/model` | Returns AI model identification information |

### Example response

```json
{
  "question": "你是什么大模型？",
  "answer": "我是 GitHub Copilot，由 GitHub 和 OpenAI 联合开发的 AI 编程助手。",
  "en_answer": "I am GitHub Copilot, an AI coding assistant developed jointly by GitHub and OpenAI."
}
```

## Running

```bash
./mvnw spring-boot:run
```

Then open <http://localhost:8080/api/model> in your browser.

## Testing

```bash
./mvnw test
```